/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate conditional compilation using preprocessor directives.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

#define MARKETING_MODE 0	// Set to 1 to have Marketing's position

int main(void)
{
#if MARKETING_MODE == 1
	printf("Our product is nice, shiny ... and the BEST in the world!!!\n");
#else
	printf("Okay, personally I wouldn't buy it.\n");
#endif

	getchar();
	return 0;
}
