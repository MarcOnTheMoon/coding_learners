/*****************************************************************************************************
 * Lecture sample code.
 * Provoke stack overflow by infinite recursion.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void recur(void);

int main(void)
{
	recur();
	getchar();
	return 0;
}

void recur(void)
{
	recur();
}
