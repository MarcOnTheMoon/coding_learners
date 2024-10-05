/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

/* Prototypes */
void printDisplayControl(int digit);

/* Main function */
int main(void)
{
	char digit;

	// Get user input
	printf("Please enter a digit: ");
	scanf("%c", &digit);
	getchar();

	// Print display control data
	if ((digit >= '0') && (digit <= '9'))
		printDisplayControl((int)(digit - '0'));

	getchar();
	return 0;
}

/* Print control data of a seven segment display */
void printDisplayControl(int digit)
{
	int display[10][7] = {
		{ 1, 1, 1, 1, 1, 1, 0 },
		{ 0, 1, 1, 0, 0, 0, 0 },
		{ 1, 1, 0, 1, 1, 0, 1 },
		{ 1, 1, 1, 1, 0, 0, 1 },
		{ 0, 1, 1, 0, 0, 1, 1 },
		{ 1, 0, 1, 1, 0, 1, 1 },
		{ 1, 0, 1, 1, 1, 1, 1 },
		{ 1, 1, 1, 0, 0, 0, 0 },
		{ 1, 1, 1, 1, 1, 1, 1 },
		{ 1, 1, 1, 1, 0, 1, 1 }
	};

	// Print data
	printf("Control for 7 segment display:\n\n a | b | c | d | e | f | g\n---+---+---+---+---+---+---\n");
	for (int i = 0; i < 7; i++)
		printf(" %d |", display[digit][i]);
	printf("\b \n");

	// Print segements
	printf("\nDisplay:\n");
	printf("  %s\n", display[digit][0] == 1 ? "---" : "   ");
	printf(" %c   %c\n", display[digit][5] == 1 ? '|' : ' ', display[digit][1] == 1 ? '|' : ' ');
	printf("  %s\n", display[digit][6] == 1 ? "---" : "   ");
	printf(" %c   %c\n", display[digit][4] == 1 ? '|' : ' ', display[digit][2] == 1 ? '|' : ' ');
	printf("  %s\n", display[digit][3] == 1 ? "---" : "   ");
}
