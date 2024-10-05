/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate result of exceeding the data range of integer types.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <limits.h>

int main(void)
{
	printf("Data range: 0 to %hu\n", USHRT_MAX);
	printf("a = 0 - 1 = %hu\n", 0 - 1);
	printf("b = %hu + 1 = %hu\n", USHRT_MAX, USHRT_MAX + 1);
	getchar();
	return 0;
}
