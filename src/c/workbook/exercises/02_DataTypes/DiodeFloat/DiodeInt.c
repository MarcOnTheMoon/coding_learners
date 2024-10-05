/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Main function */
int main(void)
{
	int resistor = 150, currentMillis = 20;
	int voltage, powerMillis;

	// Print given values
	printf("Resitor: %d Ohm\n", resistor);
	printf("Current: %d mA\n", currentMillis);

	// Calculate and print voltage and power
	voltage = (resistor * currentMillis) / 1000;
	powerMillis = voltage * currentMillis;
	printf("Voltage: %d V\n", voltage);
	printf("Power  : %d mW\n", powerMillis);

	getchar();
	return 0;
}
