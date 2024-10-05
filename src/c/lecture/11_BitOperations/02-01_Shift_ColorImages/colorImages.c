/*****************************************************************************************************
 * Lecture sample code.
 * Set and get values in RGBA color images using bit shifting and operations.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

/* Manifest constants */
#define BYTE_MASK 0xff;

/* Type definitions */
typedef unsigned char uint8;	// 8-bit unsigned integer
typedef unsigned uint32;		// 32-bit unsigned integer

/* Function prototypes */
uint32 toRGBA(uint32 red, uint32 green, uint32 blue, uint32 alpha);
uint32 getRed(uint32 pixel);
uint32 getGreen(uint32 pixel);
uint32 getBlue(uint32 pixel);
uint32 getAlpha(uint32 pixel);

/* Main function */
int main(void)
{
	uint32 pixelLow = 0x00010203;	// RGBA = (0, 1, 2, 3)
	uint32 pixelHigh = 0xfcfdfeff;	// RGBA = (252, 253, 254, 255)

	/* Set pixel data */
	printf("Set RGBA pixel:\n(11, 21, 61, 3) -> %#.8x\n\n", toRGBA(11, 21, 61, 3));

	/* Decompose color channels */
	printf("Decompose RGBA pixel:\n");
	printf(
		"%#.8x -> (%u, %u, %u, %u)\n",
		pixelLow,
		getRed(pixelLow),
		getGreen(pixelLow),
		getBlue(pixelLow),
		getAlpha(pixelLow));
	printf(
		"%#.8x -> (%u, %u, %u, %u)\n",
		pixelHigh,
		getRed(pixelHigh),
		getGreen(pixelHigh),
		getBlue(pixelHigh),
		getAlpha(pixelHigh));

	getchar();
	return 0;
}

/* Create RGBA pixel from color channel values */
uint32 toRGBA(uint32 red, uint32 green, uint32 blue, uint32 alpha)
{
	return (red << 24) | (green << 16) | (blue << 8) | alpha;
}

/* Get red color channel of ARGB pixel */
uint32 getRed(uint32 pixel)
{
	return pixel >> 24;
}

/* Get green color channel of ARGB pixel */
uint32 getGreen(uint32 pixel)
{
	return (pixel >> 16) & BYTE_MASK;
}

/* Get blue color channel of ARGB pixel */
uint32 getBlue(uint32 pixel)
{
	return (pixel >> 8) & BYTE_MASK;
}

/* Get alpha color channel of ARGB pixel */
uint32 getAlpha(uint32 pixel)
{
	return pixel & BYTE_MASK;
}
