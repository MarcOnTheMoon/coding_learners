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
	char text[] = "Es war eine Mutter, die hatte 4 Kinder:\nden Fruehling, den Sommer, den Herbst und Klaus-Guenter.";
	char letter = 'a';
	int index = 0, count = 0;

	// Count letter
	while (text[index] != '\0')
		count += (text[index++] == letter);

	// Print text and result
	printf("\"%s\"\n", text);
	printf("The text contains \'%c\' %d times.\n", letter, count);

	getchar();
	return 0;
}
