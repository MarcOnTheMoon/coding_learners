/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Main function */
int main(void)
{
	char text[] = "Es war eine Mutter, die hatte 4 Kinder:\nden Fruehling, den Sommer, den Herbst und Klaus-Guenter.";
	char nextChar;
	int index = 0, countSmall = 0, countCapital = 0, countDigit = 0, countOther = 0;

	// Count small letters, capital letters, and digits
	while ((nextChar = text[index++]) != '\0')
	{
		if ((nextChar >= 'a') && (nextChar <= 'z'))
			countSmall++;
		else if ((nextChar >= 'A') && (nextChar <= 'Z'))
			countCapital++;
		else if ((nextChar >= '0') && (nextChar <= '9'))
			countDigit++;
		else
			countOther++;
	}

	// Print text and results
	printf("\"%s\"\n", text);
	printf("Small   letters: %d\n", countSmall);
	printf("Capital letters: %d\n", countCapital);
	printf("Digits         : %d\n", countDigit);
	printf("Other symbols  : %d\n", countOther);

	getchar();
	return 0;
}
