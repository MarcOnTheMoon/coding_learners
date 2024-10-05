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
	float resistor = 150.0f, current = 0.02f;
	float voltage, power;

	// Print given values
	printf("Resitor: %.0f Ohm\n", resistor);
	printf("Current: %.0f mA\n", 1000.0 * current);

	// Calculate and print voltage and power
	voltage = resistor * current;
	power = voltage * current;
	printf("Voltage: %.1f V\n", voltage);
	printf("Power  : %.1f mW\n", 1000.0 * power);

	getchar();
	return 0;
}
