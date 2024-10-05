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

#define PIN_RECEIVER_SERVO 11   // Receiver pwm pin
#define PWM_PERIOD 16666.7      // PWM period in microsecs (60 Hz)

unsigned long pulseSumMs = 0;
int pulseCount = 0;
double pulseMeanMs;

void setup() {
  Serial.begin(9600);
  pinMode(PIN_RECEIVER_SERVO, INPUT);
}

void loop() {
  // Measure pulse length of receiver PWM
  pulseSumMs += pulseIn(PIN_RECEIVER_SERVO, HIGH);

  // Display mean length (in ms and in 0 .. 4095 for servo board PCA9685)
  pulseMeanMs = pulseSumMs / ++pulseCount;
  Serial.print((int) pulseMeanMs);
  Serial.print(" ms (");
  Serial.print((int)((pulseMeanMs / PWM_PERIOD) * 4095));
  Serial.println(" in 4095)");
}
