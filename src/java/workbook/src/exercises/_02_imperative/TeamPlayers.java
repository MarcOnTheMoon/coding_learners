package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TeamPlayers {
	public static void main(String[] args) {
		int playersOverall = 25 + 24 + 24 + 26;
		int numberTeams = 8;
		int playersPerTeam, playersRemaining;

		// Calculate results
		playersPerTeam = playersOverall / numberTeams;
		playersRemaining = playersOverall % numberTeams;

		// Print result
		System.out.println(
				playersOverall + " players distributed to " + numberTeams + " teams result in\n"
				+ playersPerTeam + " players per team with " + playersRemaining + " player(s) remaining.");
	}
}
