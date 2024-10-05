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

/* Prototypes */
void printVector(double a[], int size);
double scalarProduct(double x[], double y[], int size);

/* Main function */
int main(void)
{
	double x[] = { 1.0, -2.5, 2. };
	double y[] = { 2.5 , 1.0, 0.5 };
	int size = sizeof(x) / sizeof(x[0]);

	// Print vectors
	printf("Vectors:\nx: ");
	printVector(x, size);
	printf("y: ");
	printVector(y, size);

	// Calculate and print scalar product
	printf("\nScalar product xy = %.1f\n", scalarProduct(x, y, size));

	getchar();
	return 0;
}

/* Print array values to the console */
void printVector(double a[], int size)
{
	putchar('(');
	for (int i = 0; i < size; i++)
		printf("%.1f, ", a[i]);
	printf("\b\b)\n");
}

/* Calculare mathematical scalar product of two vectors */
double scalarProduct(double x[], double y[], int size)
{
	double product = 0.0;

	for (int i = 0; i < size; i++)
		product += x[i] * y[i];

	return product;
}
