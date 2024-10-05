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

#define PIN_SOFT_TX 6       // Connect to HM-10's RX pin
#define PIN_SOFT_RX 7       // Connect to HM-10's TX pin

SoftwareSerial bleSerial(PIN_SOFT_RX, PIN_SOFT_TX);
String message = "";

void setup() {
  // Set up serial communication
  Serial.begin(9600);       // Serial monitor within Arduino IDE
  bleSerial.begin(9600);    // Serial connection to HM-10
  Serial.println("Connected to HM-10");
}

void loop() {
  // Check, if buffer overflow occurred
  if (bleSerial.overflow())
    Serial.println("HM-10: overflow");
  
  // Read and print data available over Bluetooth LE
  int bytesAvailable = bleSerial.available();

  while (bytesAvailable-- > 0) {
    char received = bleSerial.read();
    if (isDigit(received))              // Append digits to number string
      message += received;
    else if (message.length() > 0) {    // Non-digit => Number complete
      Serial.println(message.toInt());
      bleSerial.println("Value received: " + message);
      message = "";
    }
  }
}
