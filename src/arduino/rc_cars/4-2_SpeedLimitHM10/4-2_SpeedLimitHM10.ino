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

#include <SoftwareSerial.h>
#include <Wire.h>
#include <Adafruit_PWMServoDriver.h>

/* HM-10 (bluetooth low energy) */
#define PIN_SOFT_TX 6           // Connect to HM-10's RX pin
#define PIN_SOFT_RX 7           // Connect to HM-10's TX pin

/* Receiver & ESC */
#define PIN_RECEIVER_ESC 11     // Receiver pwm pin
#define PWM_PERIOD 16666.7      // PWM period in microsecs (60 Hz)
#define PCA_CHANNEL_ESC 1       // Board PCA9685: ESC channel
#define PWM_ESC_MAX 440         // Max. pwm pulse for ESC (0..4095)
#define PWM_ESC_MIN 240         // Min. pwm pulse for ESC (0..4095)
#define PWM_LIMIT_FORWARD 385   // Max. pwm pulse for forward drive (0..4095)
#define PWM_LIMIT_BACKWARD 330  // Min. pwm pulse for backward drive (0..4095)

SoftwareSerial bleSerial(PIN_SOFT_RX, PIN_SOFT_TX);
Adafruit_PWMServoDriver pwm = Adafruit_PWMServoDriver();
int pwmLimitForward = PWM_LIMIT_FORWARD;
int pwmLimitBackward = PWM_LIMIT_BACKWARD;
String bleValue = "";           // Value string received via bluetooth

void setup() {
  // Bluetooth
  bleSerial.begin(9600);    // Serial connection to HM-10

  // Receiver and servo driver board
  pinMode(PIN_RECEIVER_ESC, INPUT);
  pwm.begin();
  pwm.setPWMFreq(1e6 / PWM_PERIOD);    // Frequency in Hz
}

void loop() {
  // Read and process data received via bluetooth
  bleSerialInput();

  // Read pwm pulse from receiver and limit forward and backward speed
  int pwmPulse = getPwmPulseInTicks(PIN_RECEIVER_ESC);
  pwmPulse = limitMinMax(pwmPulse, pwmLimitBackward, pwmLimitForward);

  // Set pwm pulse for motor
  pwm.setPWM(PCA_CHANNEL_ESC, 0, pwmPulse);
}

/* Read pwm pulse from arduino pin (in 0..4095) */
int getPwmPulseInTicks(int pin) {
  int pulseMicrosecs = pulseIn(pin, HIGH);
  return (int)((pulseMicrosecs / PWM_PERIOD) * 4095);   // Map to 0..4095
}

/* Limit a value to the range [min, max] */
int limitMinMax(int input, int min, int max) {
  if (input > max)
    return max;
  else if (input < min)
    return min;
  else
    return input;
}

/* Read data received via bluetooth and process it.
 * Data format: "Number" + 'Command char'
 */
void bleSerialInput() {
  int bleBytesAvailable = bleSerial.available();

  while (bleBytesAvailable-- > 0) {
    char received = bleSerial.read();
    if (isDigit(received))              // Append digits to number string
      bleValue += received;
    else if (bleValue.length() > 0) {   // Non-digit => Number complete
      int value = bleValue.toInt();
      switch (received) {
        case 'f':
        case 'F':
          cmdPwmLimitForwardDrive(value);
          break;
        case 'b':
        case 'B':
          cmdPwmLimitBackwardDrive(value);
          break;
        default:
          bleSerial.print("Unknown command: ");
          bleSerial.println(received);
      }
      bleValue = "";
    }
  }
}

/* Set speed limit for forward drive (pwm pulse in 0..4095) */
void cmdPwmLimitForwardDrive(int value){
  if ((value > pwmLimitBackward) && (value <= PWM_ESC_MAX)) {
    pwmLimitForward = value;
    bleSerial.println("Forward speed limit set to: ");
  } else {
    bleSerial.print("Invalid value: ");
  }
  bleSerial.println(value);
}

/* Set speed limit for backward drive (pwm pulse in 0..4095) */
void cmdPwmLimitBackwardDrive(int value){
  if ((value < pwmLimitForward) && (value >= PWM_ESC_MIN)) {
    pwmLimitBackward = value;
    bleSerial.println("Backward speed limit set to: ");
  } else {
    bleSerial.print("Invalid value: ");
  }
  bleSerial.println(value);
}
