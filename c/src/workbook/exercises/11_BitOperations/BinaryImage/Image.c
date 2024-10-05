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
#include <stdio.h>

/* Defines */
#define BITS_PER_BYTE 8
#define WIDTH 32				// Simplification: Must be multiple of 8
#define HEIGHT 2

/* Prototypes */
void printHexadecimal(const unsigned char* data, int width, int height);
void printBinaryImage(const unsigned char* data, int width, int height);

/* Main function */
int main(void)
{
	unsigned char image[WIDTH * HEIGHT / BITS_PER_BYTE] = {
		0x01, 0x23, 0x45, 0x67,
		0x89, 0xab, 0xcd, 0xef
	};

	// Print original data to the console (hexadecimal and binary)
	printf("Image data (hexadecimal):\n");
	printHexadecimal(image, WIDTH, HEIGHT);

	printf("\nCorresponding binary data:\n");
	printBinaryImage(image, WIDTH, HEIGHT);

	getchar();
	return 0;
}

/* Print bits of binary image in hex format to the console.
*
* The image data is packed into 8 pixels per value of type unsigned char.
*/
void printHexadecimal(const unsigned char* data, int width, int height)
{
	for (int y = 0; y < height; y++)
	{
		for (int x = 0; x < width / BITS_PER_BYTE; x++)
		{
			printf("0x%02x ", data[y * (width / BITS_PER_BYTE) + x]);
		}
		putchar('\n');
	}
}

/* Print bits of binary image to the console.
* 
* The image data is packed into 8 pixels per value of type unsigned char.
*/
void printBinaryImage(const unsigned char* data, int width, int height)
{
	for (int y = 0; y < height; y++)
	{
		const unsigned char* row = data + y * width / BITS_PER_BYTE;

		for (int x = 0; x < width / BITS_PER_BYTE; x++)
		{
			// Print 8 bits in current byte
			unsigned char byte = row[x];

			for (unsigned char mask = 1 << 7; mask > 0; mask >>= 1)
				printf("%d", (byte & mask) == mask);
			putchar(' ');
		}
		putchar('\n');
	}
}
