/*****************************************************************************************************
 * Lecture sample code.
 * Get numeric character code for letters in alphabet and digits.
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
	printf("Digits\t\t: %d, %d, %d, ..., %d\n", '0', '1', '2', '9');
	printf("Large letters\t: %d, %d, %d, ..., %d\n", 'A', 'B', 'C', 'Z');
	printf("Small letters\t: %d, %d, %d, ..., %d\n", 'a', 'b', 'c', 'z');
	getchar();
	return 0;
}
