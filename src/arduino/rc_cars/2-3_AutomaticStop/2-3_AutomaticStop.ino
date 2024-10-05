/*****************************************************************************************************
 * Introduction to Arduino.
 * Controlling RC cars.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.11
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <Wire.h>
#include <Adafruit_PWMServoDriver.h>

// PWM servo driver module
#define PWM_CHANNEL_ESC 1
#define PWM_NEUTRAL 340
#define PWM_DRIVE 365
#define PWM_MAX 460

// Distance sensor HC-SR04
#define TRIGGER_PIN 9
#define ECHO_PIN 8
#define MIN_RANGE_CM 2
#define MICROSEC_TO_CM 29      // Approx. time to cm at 20 C (343 m/s)
#define STOP_DISTANCE_CM  100

Adafruit_PWMServoDriver pwm = Adafruit_PWMServoDriver();
boolean isStopped = false;

void setup() {
  // Init servo driver
  pwm.begin();
  pwm.setPWMFreq(60);
  pwm.setPWM(PWM_CHANNEL_ESC, 0, PWM_DRIVE);

  // Init distance sensor
  pinMode(TRIGGER_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
}

void loop() {
  // Car already stopped => Skip loop()
  if (isStopped)
    return;

  // Stop car, if distance to next object is below STOP_DISTANCE_CM
  int distanceCm = measureDistanceInCm();
  if ((distanceCm > MIN_RANGE_CM) && (distanceCm < STOP_DISTANCE_CM)) {
    pwm.setPWM(PWM_CHANNEL_ESC, 0, PWM_NEUTRAL);
    isStopped = true;
  }
  delay(50);     // HC-SR04: Wait at least 20 ms before next measurement
}

/* Measure distance to next object */
int measureDistanceInCm() {
  // Send trigger pulse
  digitalWrite(TRIGGER_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIGGER_PIN, LOW);

  // Read echo pulse and determine distance
  // (Sound travels to object and back => Divide by 2)
  long distanceMicrosec = pulseIn(ECHO_PIN, HIGH) / 2;
  return distanceMicrosec / MICROSEC_TO_CM;
}
