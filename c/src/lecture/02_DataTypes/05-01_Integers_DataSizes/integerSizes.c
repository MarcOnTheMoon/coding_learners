/*****************************************************************************************************
 * Lecture sample code.
 * Print range and bit depth of unsigned integer types to console.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <limits.h>
#include <math.h>

int main(void)
{
	printf("unsigned short: 0 to %hu (%.0f bits)\n", USHRT_MAX, log2(USHRT_MAX));
	printf("unsigned int  : 0 to %u (%.0f bits)\n", UINT_MAX, log2(UINT_MAX));
	printf("unsigned long : 0 to %lu (%.0f bits)\n", ULONG_MAX, log2(ULONG_MAX));
	getchar();
	return 0;
}
