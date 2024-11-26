/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate debugging with Visual Studio.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2024, Marc Hensel
 * Version: 2024.11.26
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#define SIZE 2

int getSumAbs(const double a[SIZE]);

int main(void)
{
    double a[] = { -2.7, 3.1, -4 },
        double sumAbs = getSumAbs(a);
    printf("Sum of absolute values: %.1f\n", sumAbs);
    getchar();
    return 0;
}

double getSumAbs(const double a[SIZE])
{
    double sum = 0.0;
    for (int i = 1; i < SIZE; i++)
        sum = abs(a[i]);
}
