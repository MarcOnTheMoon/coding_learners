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
#define PIN_BUTTON 2     // Uno: Interrupts only for pins 2 and 3

volatile boolean isLightOff = true;

void setup() {
  pinMode(PIN_LED, OUTPUT);
  pinMode(PIN_BUTTON, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(PIN_BUTTON), toggleLight, RISING);
}

void loop() {
  // Free to do other things here ...
}

void toggleLight() {
  if (isLightOff)
    digitalWrite(PIN_LED, HIGH);
  else
    digitalWrite(PIN_LED, LOW);
  isLightOff = !isLightOff;
}
