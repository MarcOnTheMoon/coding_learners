/*****************************************************************************************************
 * Lecture sample code.
 * Exponential floating point literals.
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
	const float CHARGE_E = -1.602177e-19f;

	printf("Electron: q = %f C\n", CHARGE_E);
	printf("Electron: q = %e C\n", CHARGE_E);
	printf("Electron: q = %.1e C\n", CHARGE_E);
	getchar();
	return 0;
}
