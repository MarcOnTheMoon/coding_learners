/*****************************************************************************************************
 * Lecture sample code.
 * Printing integer numbers to the console.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	int zipCode;

	zipCode = 20099;
	printf("HAW Hamburg\nBerliner Tor 7\n%d Hamburg\n", zipCode);
	getchar();
	return 0;
}
