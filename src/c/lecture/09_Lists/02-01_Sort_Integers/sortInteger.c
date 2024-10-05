/*****************************************************************************************************
 * Lecture sample code.
 * Bubble sort, single-pass sorting approach, and quicksort for integer arrays.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Sort an array using bubble sort */
void bubbleSort(int a[], int size)
{
	int isSwapped;
	int lastID = size - 1;

	// Run iteratively through data until no neighbors are swapped in a complete run
	do
	{
		isSwapped = 0;				// Neighboring values swapped (re-ordered) in this run?

		for (int i = 1; i <= lastID; i++)
		{
			// Swap neighboring values in incorrect order
			if (a[i] < a[i - 1])
			{
				int swap = a[i];
				a[i] = a[i - 1];
				a[i - 1] = swap;

				isSwapped = 1;		// New run through data
			}
		}
		lastID--;					// Iteration moves largest remaining value to end
	} while (isSwapped);
}

/* Sort an array using a single-pass approach (similar to bubble sort) */
void singlePassSort(int a[], int size)
{
	for (int i = 1; i < size; i++)
	{
		// Swap neighboring values in incorrect order
		if (a[i] < a[i - 1])
		{
			// Swap values
			int swap = a[i];
			a[i] = a[i - 1];
			a[i - 1] = swap;

			// Move back to compare smaller value to its left neighbor
			if (i > 1)
				i -= 2;		// Incremented at end of iteration => Effectively: i = i - 1
		}
	}
}

/* Sort an array using quicksort */
void quicksort(int a[], int size)
{
	/* Sort >= 3 elements */
	if (size > 2)
	{
		int pivot = size - 1;				// Choose last element (index: size - 1) as pivot
		int left = 0, right = size - 2;		// Rest of data is in indices [0, size - 2]
		int swap;

		// Until left and right meet ...
		while (left < right)
		{
			// Move left index as far to the right as possible
			// Allow left = right + 1, if pivot already is highest number
			while ((a[left] <= a[pivot]) && (left <= right))
				left++;

			// Move right index as far to the left as possible
			while ((a[right] >= a[pivot]) && (left < right))
				right--;

			// Swap values at left and right indices, if the indices have not yet met
			if (left < right)
			{
				swap = a[left];
				a[left] = a[right];
				a[right] = swap;
			}
		}

		// Indices have met (left >= right) AND (a[left] >= a[pivot]).
		// Swap a[pivot] and a[left] => Pivot value at final position in sorted array
		swap = a[left];
		a[left] = a[pivot];
		a[pivot] = swap;

		// All values left of a[left] <= pivot value
		// All values right of a[left] >= pivot value
		// => Sort these subarrays (by recursively function call)
		quicksort(a, left);
		quicksort(&a[left + 1], size - (left + 1));
	}

	/* Sort 2 elements by comparison of values */
	else if ((size == 2) && (a[0] > a[1]))
	{
		int swap = a[0];
		a[0] = a[1];
		a[1] = swap;
	}
}
