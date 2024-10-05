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

#define PWM_FREQUENCY_HZ 60     // Frequency of PWM signals
#define PCA_CHANNEL_SERVO 0     // Board PCA9685: servo channel
#define PWM_SERVO_CENTER 340    // Neutral position in 0..4095
#define PWM_SERVO_MAX_DELTA 120 // Max. +/- deviation from neutral position

void setup() {
  Adafruit_PWMServoDriver pwm = Adafruit_PWMServoDriver();
  int minPulse = PWM_SERVO_CENTER - PWM_SERVO_MAX_DELTA;
  int maxPulse = PWM_SERVO_CENTER + PWM_SERVO_MAX_DELTA;

  pwm.begin();
  pwm.setPWMFreq(PWM_FREQUENCY_HZ);

  // Turn right (starting at neutral position)
  for (int pwmPulse = PWM_SERVO_CENTER; pwmPulse >= minPulse; pwmPulse--) {
    pwm.setPWM(PCA_CHANNEL_SERVO, 0, pwmPulse);
    delay(10);
  }

  // Turn left (starting at neutral position)
  for (int pwmPulse = PWM_SERVO_CENTER; pwmPulse <= maxPulse; pwmPulse++) {
    pwm.setPWM(PCA_CHANNEL_SERVO, 0, pwmPulse);
    delay(10);
  }

  // Stay in neutral position
  pwm.setPWM(PCA_CHANNEL_SERVO, 0, PWM_SERVO_CENTER);
}

void loop() {
}
