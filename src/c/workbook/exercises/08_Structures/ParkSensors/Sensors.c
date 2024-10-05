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
char* getSensorPositionName(sensorPosition position);
void printDistances(distanceSensor sensors[], int numberSensors);

/* Main function */
int main(void)
{
	// Define sensors
	distanceSensor sensors[] = {
		{ FRONT_LEFT, 256 },
		{ FRONT_CENTER, 204 },
		{ FRONT_RIGHT, 206 },
		{ REAR_LEFT, 461 },
		{ REAR_CENTER, 425 },
		{ REAR_RIGHT, 422 }
	};
	int numberSensors = sizeof sensors / sizeof(distanceSensor);

	// Print sensor data to the console
	printDistances(sensors, numberSensors);

	getchar();
	return 0;
}

/* Get textual name for sensor position */
char* getSensorPositionName(sensorPosition position)
{
	switch (position)
	{
	case FRONT_LEFT:
		return "Front left";
	case FRONT_CENTER:
		return "Front center";
	case FRONT_RIGHT:
		return "Front right";
	case REAR_LEFT:
		return "Rear left";
	case REAR_CENTER:
		return "Rear center";
	case REAR_RIGHT:
		return "Rear right";
	default:
		return "Unknown position";
	}
}

/* Print current measured distances of sensors to the console */
void printDistances(distanceSensor sensors[], int numberSensors)
{
	printf("Obstacle detection:\n");
	for (int i = 0; i < numberSensors; i++)
		printf("%-12s: %3d cm\n", getSensorPositionName(sensors[i].position), sensors[i].distanceCm);
}
