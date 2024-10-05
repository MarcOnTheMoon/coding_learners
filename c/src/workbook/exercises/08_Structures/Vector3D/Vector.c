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

/* Structures */
struct vector3D {
	double x;
	double y;
	double z;
};

/* Prototypes */
double scalarProduct(struct vector3D a, struct vector3D b);

/* Main function */
int main(void)
{
	struct vector3D v1 = { 2., -3., 1. };
	struct vector3D v2 = { 5., 3., 2. };
	struct vector3D v3 = { 4., 4., 4. };

	// Print vectors
	printf("v1 = (% .0f, % .0f, % .0f)^T\n", v1.x, v1.y, v1.z);
	printf("v2 = (% .0f, % .0f, % .0f)^T\n", v2.x, v2.y, v2.z);
	printf("v3 = (% .0f, % .0f, % .0f)^T\n", v3.x, v3.y, v3.z);

	// Print scalar products
	printf("\nVectors a, b are orthogonal for a * b = 0:\n");
	printf("<v1, v2> = %2.0f\n", scalarProduct(v1, v2));
	printf("<v1, v3> = %2.0f\n", scalarProduct(v1, v3));
	printf("<v2, v3> = %2.0f\n", scalarProduct(v2, v3));

	getchar();
	return 0;
}

/* Get scalar product of two 3D vectors */
double scalarProduct(struct vector3D a, struct vector3D b)
{
	return a.x * b.x + a.y * b.y + a.z * b.z;
}
