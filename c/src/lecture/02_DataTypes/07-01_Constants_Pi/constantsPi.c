/*****************************************************************************************************
 * Lecture sample code.
 * Precision of floating point constants.
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
	printf("Math pi: 3.141592654\n");
	printf("Double : %.9f\n", 3.141592654);
	printf("Float  : %.9f\n", 3.141592654f);
	getchar();
	return 0;
}
