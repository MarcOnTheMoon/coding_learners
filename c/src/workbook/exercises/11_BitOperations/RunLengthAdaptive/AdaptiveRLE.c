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

/* Prototypes */
void printBitPattern(const unsigned char* data, int size);
void printBits(unsigned value, int numberBits);
int runLengthCoding(const unsigned char* data, int size, int bitsPerWord, int isPrintBits);

/* Main function */
int main(void)
{
	unsigned char data[] = { 0x0F, 0x00, 0xFF, 0x00, 0x0F, 0xFF };		// Test data 00001111 00000000 11111111 00000000 00001111 11111111
	int byteCount = sizeof data / sizeof data[0];
	int bitCount = BITS_PER_BYTE * byteCount;
	int bitCountRLE, bitsPerCodeWord = 0;

	// Print bit pattern of input data
	printf("Original bits: ");
	printBitPattern(data, byteCount);

	// Print code lengths for different bits per code word (=> min. code length)
	printf("\n\nCompression:\nInput data: %2d bits\n", bitCount);
	for (int i = 2; i <= BITS_PER_BYTE; i++)
	{
		int count = runLengthCoding(data, byteCount, i, 0);

		if ((bitsPerCodeWord == 0) || (count < bitCountRLE))
		{
			bitsPerCodeWord = i;
			bitCountRLE = count;
		}

		printf("%d-bit code: %2d bits (%5.1f %%)\n", i, count, (100.0 * count) / (double)bitCount);
	}

	// Print values of run length code
	printf("\nCode (%d bits): ", bitsPerCodeWord);
	bitCountRLE = runLengthCoding(data, byteCount, bitsPerCodeWord, 1);
	putchar('\n');

	getchar();
	return 0;
}

/* Print bit pattern of a series of bytes to the console.
*
* Bytes are separated by a space.
*/
void printBitPattern(const unsigned char* data, int size)
{
	// Run through bytes
	for (int i = 0; i < size; i++)
	{
		unsigned char byte = data[i];

		// Run through bits and print
		for (unsigned char mask = 1 << 7; mask > 0; mask >>= 1)
			printf("%d", (byte & mask) == mask);
		putchar(' ');
	}
}

/* Print unsigned integer value using a specific number of bits. */
void printBits(unsigned value, int numberBits)
{
	unsigned mask = 1 << numberBits;

	while (mask >>= 1)
		printf("%d", (value & mask) == mask);
	putchar(' ');
}

/* Print run length encoded data for a series of bytes.
*
* @param data Series of bytes to encode
* @param size Number of bytes in series
* @param bitsPerWord Number of bits to encode each value of the resulting run length code
* @param isPrintBits Print code to console (true), else do not print
* @return number of bits that would be required for run length encoded data (using the specific bit depth)
*/
int runLengthCoding(const unsigned char* data, int size, int bitsPerWord, int isPrintBits)
{
	int bitValue = 0;						// Bits with which value (0's or 1's) are currently counted?
	int bitCount = 0;						// How many bits with same value in a row so far?
	int maxCount = (1 << bitsPerWord) - 1;	// Maximum decimal count that can be encoded (determined by number bits per encoded value)
	int wordCount = 0;						// Number of code values so far

	// Run through all bytes
	for (int byteID = 0; byteID < size; byteID++)
	{
		unsigned char byte = data[byteID];

		// Run through all bits of the byte
		for (unsigned char mask = (1 << 7); mask > 0; mask >>= 1)
		{
			int bit = ((byte & mask) == mask);

			// Bit with expected value (e. g., same value as last one => keep counting)
			if (bit == bitValue)
			{
				bitCount++;

				// Reached maximum count value that can be encoded (=> toggle value)
				if (bitCount == maxCount)
				{
					if (isPrintBits)
						printBits(bitCount, bitsPerWord);
					bitValue = !bitValue;
					bitCount = 0;
					wordCount++;
				}
			}

			// Bit value has changed (=> toggle value and start counting)
			else
			{
				if (isPrintBits)
					printBits(bitCount, bitsPerWord);
				bitValue = !bitValue;
				bitCount = 1;
				wordCount++;
			}
		}
	}

	// Result of last ongoing count
	if (bitCount > 0)
	{
		if (isPrintBits)
			printBits(bitCount, bitsPerWord);
		wordCount++;
	}

	return bitsPerWord * wordCount;
}
