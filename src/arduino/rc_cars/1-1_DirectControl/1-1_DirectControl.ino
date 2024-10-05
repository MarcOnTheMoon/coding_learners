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
 
#define PIN_PWM_SERVO 12    // PWM output pin
#define PWM_PERIOD 16666    // PWM period in microsecs (60 Hz)
#define PWM_MIN 1100        // Min. pwm pulse in microsecs
#define PWM_MAX 1900        // Max. pwm pulse in microsecs

int pwmServo = 1500;        // Neutral servo position: 1.5 ms
int pwmServoDelta = 10;     // Increment/decrement of pwm pulse in µs

void setup() {
  pinMode(PIN_PWM_SERVO, OUTPUT);
}

void loop() {
  // Turn steering left or right
  pwmServo += pwmServoDelta;
  if ((pwmServo >= PWM_MAX) || (pwmServo <= PWM_MIN))
    pwmServoDelta = -pwmServoDelta;
  
  // Set PWM pulse to output pin
  digitalWrite(PIN_PWM_SERVO, HIGH);
  delayMicroseconds(pwmServo);
  digitalWrite(PIN_PWM_SERVO, LOW);
  delayMicroseconds(PWM_PERIOD - pwmServo);
}
