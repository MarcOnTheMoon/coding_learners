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
#define PWM_PERIOD_MICROS 4000        // Period T in µs of PWM signal

double percentPower = 100.0;          // Perentage of "high" in period
double deltaPercent = 0.05;           // Decresing percentage in each loop

void setup() {
  pinMode(PIN_LED, OUTPUT);
}

void loop() {
  unsigned int pulseLengthMicros = (unsigned int)(percentPower/100.0 * PWM_PERIOD_MICROS);
  digitalWrite(PIN_LED, HIGH);
  delayMicroseconds(pulseLengthMicros);
  digitalWrite(PIN_LED, LOW);
  delayMicroseconds(PWM_PERIOD_MICROS - pulseLengthMicros);
  percentPower = max(percentPower - deltaPercent, 0.0);
}
