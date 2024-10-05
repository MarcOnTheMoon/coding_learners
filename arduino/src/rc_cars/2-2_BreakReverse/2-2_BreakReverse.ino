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

#define PWM_CHANNEL_ESC 1
#define PWM_NEUTRAL 340
#define PWM_MAX 460
#define PWM_BREAK 240
#define ACCELERATION_TIME_MS 2500

Adafruit_PWMServoDriver pwm = Adafruit_PWMServoDriver();

void setup() {
  // Init servo driver
  int pwmLength = PWM_NEUTRAL;
  pwm.begin();
  pwm.setPWMFreq(60);
  pwm.setPWM(PWM_CHANNEL_ESC, 0, pwmLength);

  // Accelerate
  unsigned long startMillis = millis();
  while (millis() - startMillis < ACCELERATION_TIME_MS) {
    if (pwmLength < PWM_MAX)
      pwm.setPWM(PWM_CHANNEL_ESC, 0, ++pwmLength);
    delay(100);
  }

  // Break
  pwmLength = PWM_BREAK;
  pwm.setPWM(PWM_CHANNEL_ESC, 0, pwmLength);
  delay(1000);

  // Neutral 
  pwmLength = PWM_NEUTRAL;
  pwm.setPWM(PWM_CHANNEL_ESC, 0, pwmLength);
}

void loop() {
}
