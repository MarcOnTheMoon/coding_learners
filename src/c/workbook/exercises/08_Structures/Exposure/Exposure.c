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
struct exposure {
	double aperture;
	double timeSec;
	int iso;
};

/* Prototypes */
void printExposureData(struct exposure data);

/* Main function */
int main(void)
{
	struct exposure exposures[] = {
		{ 2.8, 1. / 60., 200 },
		{ 5.6, 1. / 250., 800 },
		{ 16.0, 3., 100 }
	};
	int numberExposures = sizeof exposures / sizeof(struct exposure);

	// Print exposure data
	printf("Exposures:\n");
	for (int i = 0; i < numberExposures; i++)
	{
		printExposureData(exposures[i]);
		putchar('\n');
	}

	getchar();
	return 0;
}

/* Print exposure data */
void printExposureData(struct exposure data)
{
	if (data.timeSec < 1.0)
		printf("1/%-4.1f | 1/%-3d sec | ISO %d", data.aperture, (int)(1.0 / data.timeSec), data.iso);
	else
		printf("1/%-4.1f | %-5d sec | ISO %d", data.aperture, (int)(data.timeSec), data.iso);
}
