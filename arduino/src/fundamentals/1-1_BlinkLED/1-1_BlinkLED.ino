/*****************************************************************************************************
 * Introduction to Arduino (Fundamentals)
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/
 
#define PIN_LED 12

void setup() {
  pinMode(PIN_LED, OUTPUT);       // Set pin to be output pin
}

void loop() {
  digitalWrite(PIN_LED, HIGH);    // Turn LED on
  delay(2000);                    // Wait for 2s
  digitalWrite(PIN_LED, LOW);     // Turn LED off
  delay(1000);                    // Wait for 1s
}
