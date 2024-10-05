/*****************************************************************************************************
 * Lecture sample code.
 * File scope variable who is known from line of definition until end of file.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void knowWho(void);

void dontKnowWho(void)
{
}

char *who = "It's me!";

int main(void)
{
	printf("I know who: %s\n", who);
	dontKnowWho();
	knowWho();

	getchar();
	return 0;
}

void knowWho(void)
{
	printf("Me too    : %s\n", who);
}