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
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

/* Prototypes */
double centigrade2Fahrenheit(double centigrade);
double fahrenheit2Centigrade(double fahrenheit);

/* Main function */
int main(void)
{
	double centigrade, fahrenheit;

	// Get user input: temperature in degree Celsius
	printf("Please enter temperature in centigrade: ");
	scanf("%lf", &centigrade);
	getchar();

	// Calculate and print temperature in Fahrenheit and convert back to degree Celsius
	fahrenheit = centigrade2Fahrenheit(centigrade);
	centigrade = fahrenheit2Centigrade(fahrenheit);
	printf("Converted to Fahrenheit     : %.1f\n", fahrenheit);
	printf("Converted back to centigrade: %.1f\n", centigrade);

	getchar();
	return 0;
}

/* Convert temperature from degree Celsius to Fahrenheit.
*
* @param centigrade Temperature in degree Celsius
* @return corresponding temperature in Fahrenheit
*/
double centigrade2Fahrenheit(double centigrade)
{
	return 9. / 5. * centigrade + 32.0;
}

/* Convert temperature from Fahrenheit to degree Celsius.
*
* @param fahrenheit Temperature in Fahrenheit
* @return corresponding temperature in degree Celsius
*/
double fahrenheit2Centigrade(double fahrenheit)
{
	return (fahrenheit - 32.0) * 5. / 9.;
}
