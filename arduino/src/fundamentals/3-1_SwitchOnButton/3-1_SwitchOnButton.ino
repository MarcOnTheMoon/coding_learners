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
#define PIN_BUTTON 5

boolean isLightOff = true;

void setup() {
  pinMode(PIN_LED, OUTPUT);
  pinMode(PIN_BUTTON, INPUT);
}

void loop() {
  if (isLightOff) {
    int inputState = digitalRead(PIN_BUTTON);
    boolean isButtonPressed = (inputState == HIGH);
    
    if (isButtonPressed) {
      digitalWrite(PIN_LED, HIGH);
      isLightOff = false;
    }
  }
}
