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

/* Enumerations */
typedef enum {
	FRONT_CENTER,
	FRONT_LEFT,
	FRONT_RIGHT,
	REAR_CENTER,
	REAR_LEFT,
	REAR_RIGHT
} sensorPosition;

/* Structures */
typedef struct {
	sensorPosition position;
	int distanceCm;
} distanceSensor;

/* Prototypes */
int readDistanceSensor(distanceSensor sensors[], int numberSensors, sensorPosition position, int* distance);
void displayParkPilot(distanceSensor sensors[], int numberSensors);

/* Main function */
int main(void)
{
	// Define sensors
	distanceSensor sensors[] = {
		{ FRONT_LEFT, 256 },
		{ FRONT_CENTER, 204 },
		{ FRONT_RIGHT, 52 },
		{ REAR_CENTER, 425 }
	};
	int numberSensors = sizeof sensors / sizeof(distanceSensor);

	// Display park pilot (car with measured distances)
	displayParkPilot(sensors, numberSensors);

	getchar();
	return 0;
}

/* Read measured distance in cm from a distance sensor at a specific position.
* 
* @param sensors Collection of sensors
* @param numberSensors Number of sensors in collection of sensors
* @param position Sensor position to read distance from
* @param distance [out] Distance read from sensor
* @return true (1) if sensor found and distance read, else false (0)
*/
int readDistanceSensor(distanceSensor sensors[], int numberSensors, sensorPosition position, int* distance)
{
	// Seek sensor at desired position and return distance
	for (int i = 0; i < numberSensors; i++)
	{
		// Sensor found
		if (sensors[i].position == position)
		{
			*distance = sensors[i].distanceCm;
			return 1;
		}
	}

	// Sensor not found
	return 0;
}

/* Print park pilot with schematic car and distances to the console.
* 
* Displays distances for all sensors in collection, only, and leaves other positions empty.
* 
* @param sensors Collection of sensors
* @param numberSensors Number of sensors in collection of sensors
*/
void displayParkPilot(distanceSensor sensors[], int numberSensors)
{
	int distanceCm;

	// Print front distances
	printf("Park pilot:\n\n");
	if (readDistanceSensor(sensors, numberSensors, FRONT_LEFT, &distanceCm))
		printf("%4d ", distanceCm);
	else
		printf("     ");
	if (readDistanceSensor(sensors, numberSensors, FRONT_CENTER, &distanceCm))
		printf("%4d  ", distanceCm);
	else
		printf("      ");
	if (readDistanceSensor(sensors, numberSensors, FRONT_RIGHT, &distanceCm))
		printf("%-4d\n", distanceCm);
	else
		printf("\n");

	// Print car
	printf("    v-----v\n");
	printf("    |     |\n");
	printf("    | --- |\n");
	printf("    |     |\n");
	printf("    |     |\n");
	printf("    |     |\n");
	printf("    x-----x\n");

	// Print rear distances
	if (readDistanceSensor(sensors, numberSensors, REAR_LEFT, &distanceCm))
		printf("%4d ", distanceCm);
	else
		printf("     ");
	if (readDistanceSensor(sensors, numberSensors, REAR_CENTER, &distanceCm))
		printf("%4d  ", distanceCm);
	else
		printf("      ");
	if (readDistanceSensor(sensors, numberSensors, REAR_RIGHT, &distanceCm))
		printf("%-4d\n", distanceCm);
	else
		printf("\n");
}
