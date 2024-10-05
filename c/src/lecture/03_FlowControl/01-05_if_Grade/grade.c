/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate nested if/else-statements.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	int grade;

	/* Get user input: grade in 0 ... 15 */
	printf("Please enter your grade: ");
	scanf("%d", &grade);
	getchar();

	/* Print to the console */
	if ((grade >= 0) && (grade <= 15))
	{
		if (grade >= 5)
			printf("Congratulations, you have passed the exam!\n");
		else
			printf("Sorry, you have failed in the exam.\n");
	}
	else
		printf("Grade %d?! Please be honest, will you?\n", grade);

	getchar();
	return 0;
}
