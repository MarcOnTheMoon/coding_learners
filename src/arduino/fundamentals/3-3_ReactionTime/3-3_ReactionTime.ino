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

void setup() {
  Serial.begin(9600);
  randomSeed(analogRead(0));    // Init random generator
  pinMode(PIN_LED, OUTPUT);
  pinMode(PIN_BUTTON, INPUT);
}

void loop() {
  // Wait a random period before switching LED on
  delay(random(3000, 10000));
  digitalWrite(PIN_LED, HIGH);

  // Wait for button pressed
  unsigned long startTime = millis();
  while (digitalRead(PIN_BUTTON) != HIGH) {
  }
  unsigned long stopTime = millis();

  // Display measured time
  Serial.print("Time taken: ");
  Serial.print((stopTime - startTime) / 1000.0);
  Serial.println(" s");

  // Next game after a couple of seconds
  delay(5000);
  digitalWrite(PIN_LED, LOW);
}
