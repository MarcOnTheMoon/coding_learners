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
	WIN,
	DRAW,
	DEFEAT
} gameResult;

/* Structures */
typedef struct {
	int wins;
	int draws;
	int defeats;
} teamSeason;

/* Prototypes */
void addGameResult(teamSeason* team, gameResult result);
int getScore(teamSeason team);

/* Main function */
int main(void)
{
	teamSeason team = { 0, 0, 0 };

	// Add results and display team's data
	printf("        win drw def | points\n");
	addGameResult(&team, WIN);
	printf("Win   :  %d   %d   %d  |  %3d\n", team.wins, team.draws, team.defeats, getScore(team));
	addGameResult(&team, DEFEAT);
	printf("Defeat:  %d   %d   %d  |  %3d\n", team.wins, team.draws, team.defeats, getScore(team));
	addGameResult(&team, WIN);
	printf("Win   :  %d   %d   %d  |  %3d\n", team.wins, team.draws, team.defeats, getScore(team));
	addGameResult(&team, DRAW);
	printf("Draw  :  %d   %d   %d  |  %3d\n", team.wins, team.draws, team.defeats, getScore(team));
	addGameResult(&team, WIN);
	printf("Win   :  %d   %d   %d  |  %3d\n", team.wins, team.draws, team.defeats, getScore(team));

	getchar();
	return 0;
}

/* Add game result to team's season */
void addGameResult(teamSeason* team, gameResult result)
{
	if (result == WIN)
		team->wins++;
	else if (result == DRAW)
		team->draws++;
	else if (result == DEFEAT)
		team->defeats++;
}

/* Get overall score of team in season. */
int getScore(teamSeason team)
{
	return 3 * team.wins + team.draws;
}
