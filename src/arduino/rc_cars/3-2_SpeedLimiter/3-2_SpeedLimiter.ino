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

#define PIN_RECEIVER_ESC 11   // Receiver pwm pin
#define PWM_PERIOD 16666.7    // PWM period in microsecs (60 Hz)
#define PCA_CHANNEL_ESC 1     // Board PCA9685: ESC channel
#define PWM_MIN_LIMIT 340     // Min. pwm pulse backward drive (0..4095)
#define PWM_MAX_LIMIT 380     // Max. pwm pulse forward drive (0..4095)

Adafruit_PWMServoDriver pwm = Adafruit_PWMServoDriver();

void setup() {
  pinMode(PIN_RECEIVER_ESC, INPUT);
  pwm.begin();
  pwm.setPWMFreq(1e6 / PWM_PERIOD);    // Frequency in Hz
}

void loop() {
  // Read pwm pulse from receiver
  int pwmPulseMicrosecs = pulseIn(PIN_RECEIVER_ESC, HIGH);
  int pwmPulseTicks = (int)((pwmPulseMicrosecs / PWM_PERIOD) * 4095);

  // Limit forward and backward speed
  if (pwmPulseTicks > PWM_MAX_LIMIT)
    pwmPulseTicks = PWM_MAX_LIMIT;
  else if (pwmPulseTicks < PWM_MIN_LIMIT)
    pwmPulseTicks = PWM_MIN_LIMIT;

  // Set pwm pulse for motor
  pwm.setPWM(PCA_CHANNEL_ESC, 0, pwmPulseTicks);
}
