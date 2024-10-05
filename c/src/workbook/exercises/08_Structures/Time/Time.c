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
#include <math.h>

/* Defines */
#define SIZE_INVALID 6
#define SIZE_DIFF 3

/* Enumerations */
typedef enum {
	TIME_INVALID = 0,
	TIME_OK
} timeStatus;

/* Structures */
typedef struct {
	int hour;
	int min;
	int sec;
} time;

/* Prototypes */
timeStatus isTimeValid(time);
time timeFromSec(unsigned);
time timePeriod(time, time);

/* Main function */
int main(void)
{
	time validTime = { 9, 24, 16 };				// Validity
	time invalidTimes[SIZE_INVALID] = {
		{ -1, 0, 0 },{ 24, 0, 0 },
		{ 0, -1, 0 },{ 0, 60, 0 },
		{ 0, 0, -1 },{ 0, 0, 60 } };

	unsigned sec = 10 * 3600 + 5 * 60 + 18;		// Create time
	time newTime = timeFromSec(sec);

	time periodTimes[SIZE_DIFF] = {				// Time differences
		{ 9, 24, 16 }, { 9, 25, 21 }, { 8, 1, 0 } };
	time period01 = timePeriod(periodTimes[0], periodTimes[1]);
	time period02 = timePeriod(periodTimes[0], periodTimes[2]);

	// Check validity of time data
	printf("Valid time   : %d\n", isTimeValid(validTime));
	printf("Invalid times:");
	for (int i = 0; i < SIZE_INVALID; i++)
		printf(" %d", isTimeValid(invalidTimes[i]));
	printf("\n\n");

	// Create new time from seconds since midnight
	printf("Initialize from seconds since midnight:\n");
	printf("%u sec => %02d:%02d:%02d\n\n", sec, newTime.hour, newTime.min, newTime.sec);

	// Time periods
	printf("Periods:\n");
	for (int i = 0; i < SIZE_DIFF; i++)
		printf("t%d: %02d:%02d:%02d\n", i, periodTimes[i].hour, periodTimes[i].min, periodTimes[i].sec);
	printf("Period with t0 and t1: %02d:%02d:%02d\n", period01.hour, period01.min, period01.sec);
	printf("Period with t0 and t2: %02d:%02d:%02d\n", period02.hour, period02.min, period02.sec);

	getchar();
	return 0;
}

/* Check if data in type time is valid */
timeStatus isTimeValid(time testTime)
{
	int isHourValid = (testTime.hour >= 0) && (testTime.hour <= 23);
	int isMinValid = (testTime.min >= 0) && (testTime.min <= 59);
	int isSecValid = (testTime.sec >= 0) && (testTime.sec <= 59);

	return (isHourValid && isMinValid && isSecValid) ? TIME_OK : TIME_INVALID;
}

/* Create time from seconds since midnight */
time timeFromSec(unsigned sec)
{
	time newTime;
	newTime.sec = sec % 60;
	newTime.min = (sec / 60) % 60;
	newTime.hour = sec / 3600;			// 60 sec * 60 min = 3600

	return newTime;
}

/* Time periods */
time timePeriod(time start, time stop)
{
	int startSec = 3600 * start.hour + 60 * start.min + start.sec;
	int stopSec = 3600 * stop.hour + 60 * stop.min + stop.sec;

	return timeFromSec(abs(stopSec - startSec));
}
