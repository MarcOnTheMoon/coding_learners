/*****************************************************************************************************
 * Lecture sample code.
 * Invert 8-bit gray-valued pixel.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#define SIZE 4

int main(void)
{
	/* Define array */
	short gray[SIZE][SIZE] = { { 0, 6, 2, 8 },{ 122, 102, 137, 126 },{ 242, 255, 231, 247 },{ 15, 21, 16, 8 } };

	/* Invert image */
	for (int y = 0; y < SIZE; y++)
	{
		for (int x = 0; x < SIZE; x++)
			gray[y][x] = 255 - gray[y][x];
	}

	/* Print image data to the console */
	for (int y = 0; y < SIZE; y++)
	{
		for (int x = 0; x < SIZE; x++)
			printf("%3hd ", gray[y][x]);
		putchar('\n');
	}
	putchar('\n');

	getchar();
	return 0;
}
