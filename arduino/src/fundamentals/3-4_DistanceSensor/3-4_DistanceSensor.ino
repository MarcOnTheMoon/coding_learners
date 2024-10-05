/*****************************************************************************************************
 * Introduction to Arduino (Fundamentals)
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define TRIGGER_PIN 9
#define ECHO_PIN 8
#define MIN_RANGE_CM 2
#define MAX_RANGE_CM 300
#define MICROSEC_TO_CM 29     // Approx. time to cm at 20 C (343 m/s)

void setup() {
  Serial.begin(9600);
  pinMode(TRIGGER_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
}

void loop() {
  // Send trigger pulse
  digitalWrite(TRIGGER_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIGGER_PIN, LOW);

  // Read echo pulse and determine distance
  // (Sound travels to object and back => Divide by 2)
  long distanceMicrosec = pulseIn(ECHO_PIN, HIGH) / 2;
  int distanceCm = distanceMicrosec / MICROSEC_TO_CM;

  if ((distanceCm >= MIN_RANGE_CM) && (distanceCm <= MAX_RANGE_CM)) {
    Serial.print(distanceCm);
    Serial.println(" cm");
  } else {
    Serial.println("Distance not within range (2 .. 300 cm)");
  }
  delay(500);
}
