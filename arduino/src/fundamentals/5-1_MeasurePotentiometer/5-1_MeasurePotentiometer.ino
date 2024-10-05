/*****************************************************************************************************
 * Introduction to Arduino (Fundamentals)
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define PIN_INPUT A0

void setup() {
  Serial.begin(9600);
}

void loop() {
  int measured = analogRead(PIN_INPUT);
  double voltage = measured / 1023.0 * 5.0;
  Serial.print(voltage);
  Serial.println(" V");
  delay(200);
}
