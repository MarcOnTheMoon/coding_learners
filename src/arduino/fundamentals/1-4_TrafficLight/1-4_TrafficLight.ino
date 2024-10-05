/*****************************************************************************************************
 * Introduction to Arduino (Fundamentals)
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define PIN_RED 12
#define PIN_YELLOW 11
#define PIN_GREEN 10
#define TIME_LONG_MS 7000       // Time for green and red lights
#define TIME_SWITCH_MS 2000     // Time when switching between greem and red

void setup() {
  pinMode(PIN_RED, OUTPUT);
  pinMode(PIN_YELLOW, OUTPUT);
  pinMode(PIN_GREEN, OUTPUT);
}

void loop() {
  setLights(HIGH, LOW, LOW, TIME_LONG_MS);      // Red
  setLights(HIGH, HIGH, LOW, TIME_SWITCH_MS);   // Red & yellow
  setLights(LOW, LOW, HIGH, TIME_LONG_MS);      // Green
  setLights(LOW, HIGH, LOW, TIME_SWITCH_MS);    // Yellow
}

void setLights(int stateRed, int stateYellow, int stateGreen, int timeMs) {
  digitalWrite(PIN_RED, stateRed);
  digitalWrite(PIN_YELLOW, stateYellow);
  digitalWrite(PIN_GREEN, stateGreen);
  delay(timeMs);
}
