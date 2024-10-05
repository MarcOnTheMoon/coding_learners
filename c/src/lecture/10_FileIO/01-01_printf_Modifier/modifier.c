/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate modifiers for printf() function.
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
	printf("Octal         : %#o\n", 27);
	printf("Hexadecimal   : %#x\n", 27);
	printf("Minimum width : %#6x\n", 27);
	printf("Integer       : %#.4x\n", 27);
	printf("Floating-point: %+#05.0f\n", 7.1);

	getchar();
	return 0;
}
