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

/* Main function */
int main(void)
{
	int playersOverall = 25 + 24 + 24 + 26, numberTeams = 8;
	int playersPerTeam, playersRemaining;

	// Calculate results
	playersPerTeam = playersOverall / numberTeams;
	playersRemaining = playersOverall % numberTeams;

	// Print result
	printf(
		"%d players distributed to %d teams result in\n%d players per team with %d player(s) remaining.\n",
		playersOverall, numberTeams, playersPerTeam, playersRemaining);

	getchar();
	return 0;
}
