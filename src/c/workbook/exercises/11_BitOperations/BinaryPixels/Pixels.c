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
int getBinaryPixel(const unsigned char* data, int width, int x, int y);
void setBinaryPixel(unsigned char* data, int width, int x, int y, int value);
void printBinaryImage(const unsigned char* data, int width, int height);

/* Main function */
int main(void)
{
	unsigned char image[HEIGHT * WIDTH / BITS_PER_BYTE] = {
		0x01, 0x23, 0x45, 0x67,
		0x89, 0xab, 0xcd, 0xef
	};

	// Print original data to the console
	printf("Binary image data:\n");
	printBinaryImage(image, WIDTH, HEIGHT);

	// Print a specific byte to the console
	printf("\nFirst byte in row 2 : ");
	for (int x = 0; x < BITS_PER_BYTE; x++)
		printf("%d", getBinaryPixel(image, WIDTH, x, 1));

	// Set specific pixel
	printf("\nSet 2nd bit to 1    : ");
	setBinaryPixel(image, WIDTH, 1, 1, 1);
	for (int x = 0; x < BITS_PER_BYTE; x++)
		printf("%d", getBinaryPixel(image, WIDTH, x, 1));

	// Set specific pixel
	printf("\nSet 2nd bit to 0    : ");
	setBinaryPixel(image, WIDTH, 1, 1, 0);
	for (int x = 0; x < BITS_PER_BYTE; x++)
		printf("%d", getBinaryPixel(image, WIDTH, x, 1));

	getchar();
	return 0;
}

/* Get the value of a specific pixel.
* 
* @param data Binary image data (8 pixels stored in each byte)
* @param width Image width in pixel
* @param x x-coordinate of pixel to read [0 .. (width - 1)]
* @param y y-coordinate of pixel to read [0 .. (height - 1)]
* @return pixel value at position (x, y) in [0, 1]
*/
int getBinaryPixel(const unsigned char* data, int width, int x, int y)
{
	const unsigned char* row = data + y * width / BITS_PER_BYTE;
	unsigned char byte = row[x / BITS_PER_BYTE];
	int bitNumber = x % BITS_PER_BYTE;
	unsigned char mask = 1 << (BITS_PER_BYTE - (bitNumber + 1));

	return (byte & mask) == mask;
}

/* Set the value of a specific pixel.
*
* @param data Binary image data (8 pixels stored in each byte)
* @param width Image width in pixel
* @param x x-coordinate of pixel to set [0 .. (width - 1)]
* @param y y-coordinate of pixel to set [0 .. (height - 1)]
* @param value Pixel value to set [0, 1]
*/
void setBinaryPixel(unsigned char* data, int width, int x, int y, int value)
{
	unsigned char* row = data + y * width / BITS_PER_BYTE;
	unsigned char* byte = row + (x / BITS_PER_BYTE);
	int bitNumber = x % BITS_PER_BYTE;
	unsigned char mask = 1 << (BITS_PER_BYTE - (bitNumber + 1));

	if (value)
		*byte |= mask;
	else
		*byte &= ~mask;
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
