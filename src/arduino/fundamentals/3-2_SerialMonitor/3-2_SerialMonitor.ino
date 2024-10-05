/*****************************************************************************************************
 * Introduction to Arduino (Fundamentals)
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_arduino
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

void setup() {
  Serial.begin(9600);                             // Establish serial connection

  int answer = 42;
  Serial.println("Printing with line break.");    // Print line
  Serial.print("The answer is: ");                // Print without line break
  Serial.println(answer);                         // Print value of variable
}

void loop() {
}
