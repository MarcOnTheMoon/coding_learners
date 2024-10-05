/*****************************************************************************************************
 * Introduction to Arduino (Fundamentals)
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define PIN_LED 11      // Must be a PWM port (i.e., marked by a tilde ~)

int pwmValue = 255;

void setup() {
}

void loop() {
  analogWrite(PIN_LED, pwmValue);
  delay(20);
  pwmValue = max(pwmValue - 1 , 0);
}
