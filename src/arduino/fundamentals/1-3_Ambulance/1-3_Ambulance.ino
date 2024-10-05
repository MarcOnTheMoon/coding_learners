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
#define TIME_FLASH_MS 65

void setup() {
  pinMode(PIN_LED, OUTPUT);
}

void blink(int pin, int timeMs) {
  digitalWrite(pin, HIGH);
  delay(timeMs);
  digitalWrite(pin, LOW);
}

void loop() {
  // Blink twice in 200 ms
  blink(PIN_LED, TIME_FLASH_MS);
  delay(200 - 2 * TIME_FLASH_MS);
  blink(PIN_LED, TIME_FLASH_MS);
  
  // Lights off for 300 ms
  delay(300);
}
