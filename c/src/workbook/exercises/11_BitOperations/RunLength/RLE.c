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
#define BITS_PER_CODE_WORD 4		// Number of bits used for each runlength encoded value

/* Prototypes */
void printBitPattern(const unsigned char* data, int size);
int runLengthCoding(const unsigned char* data, int size, int bitsPerWord);

/* Main function */
int main(void)
{
	unsigned char data[] = { 0x0F, 0x00, 0xFF, 0x00, 0x0F, 0xFF };		// Test data 00001111 00000000 11111111 00000000 00001111 11111111
	int byteCount = sizeof data / sizeof data[0];
	int bitCount = BITS_PER_BYTE * byteCount;
	int bitCountRLE;

	// Print bit pattern of input data
	printf("Original bits: ");
	printBitPattern(data, byteCount);

	// Print values of run length code
	printf("\nCode (%d bits): ", BITS_PER_CODE_WORD);
	bitCountRLE = runLengthCoding(data, byteCount, BITS_PER_CODE_WORD);

	// Print number of bits in input vs. run length encoded data
	printf("\n\nCompression:\nInput  : %2d bits", bitCount);
	printf("\nEncoded: %2d bits (%.1f %%)\n", bitCountRLE, (100.0 * bitCountRLE) / (double)bitCount);

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

/* Print run length encoded data for a series of bytes.
* 
* @param data Series of bytes to encode
* @param size Number of bytes in series
* @param bitsPerWord Number of bits to encode each value of the resulting run length code
* @return number of bits that would be required for run length encoded data (using the specific bit depth)
*/
int runLengthCoding(const unsigned char* data, int size, int bitsPerWord)
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
					printf("%d*%d | ", bitCount, bitValue);
					bitValue = !bitValue;
					bitCount = 0;
					wordCount++;
				}
			}

			// Bit value has changed (=> toggle value and start counting)
			else
			{
				printf("%d*%d | ", bitCount, bitValue);
				bitValue = !bitValue;
				bitCount = 1;
				wordCount++;
			}
		}
	}

	// Result of last ongoing count
	if (bitCount > 0)
	{
		printf("%d*%d | ", bitCount, bitValue);
		wordCount++;
	}
	printf("\b\b ");

	return bitsPerWord * wordCount;
}
