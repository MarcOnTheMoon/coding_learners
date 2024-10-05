/*****************************************************************************************************
 * Provided file for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.18
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Function prototypes (provided by examiner) */
double absolute(complex z);
complex add(complex a, complex b);
complex multiply(complex a, complex b);

/* Main function (provided by examiner) */
int main(void)
{
	complex z1 = { 3., 4. };
	complex z2 = { 2.0, -1. };
	complex sum, product;

	/* Print complex numbers to the console */
	printf("Input data:\n");
	printf("z1 = %.1f %+.1fj\n", z1.real, z1.imag);
	printf("z2 = %.1f %+.1fj\n", z2.real, z2.imag);

	/* Absolute values */
	printf("\nAbsolute values:\n");
	printf("|z1| = %.3f\n", absolute(z1));
	printf("|z2| = %.3f\n", absolute(z2));

	/* Mathematical operations */
	printf("\nMathematical operations:\n");
	sum = add(z1, z2);
	product = multiply(z1, z2);
	printf("z1 + z2 = %.1f %+.1fj\n", sum.real, sum.imag);
	printf("z1 * z2 = %.1f %+.1fj\n", product.real, product.imag);

	getchar();
	return 0;
}
