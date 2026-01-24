package dice_game;

/** Sample app provided for the final exam E3-OP.
 *
 * @version SoSe 2023
 * @author Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">http://www.haw-hamburg.de/marc-hensel</a>)
 */
public class GameApp {
    public static void printScorecard(Scorecard scorecard) {
        StringBuilder builder = new StringBuilder();

        builder.append("  1 |  2 |  3 |  4 |  5 |  6 |\n");
        for (int i = 1; i <= 6; i++) {
            if (scorecard.isScoreFieldEmpty(i))
                builder.append("  - |");
            else
                builder.append(String.format(" %2d |", scorecard.getScoreField(i)));
        }
        builder.append(String.format(" (%d Punkte)\n", scorecard.getScore()));
        System.out.println(builder.toString());

    }

    public static void main(String[] args) {
        Game game = new Game();

        game.newGame();

        // Throw dice 6 times and assign to the scores of 1, 2, .., 6
        for (int i = 1; i <= 6; i++) {
            System.out.println("Wurf: " + game.getDice());
            System.out.println("Wahl: " + i);
            game.selectFieldAndRoll(i);
            printScorecard(game.getScorecard());
        }
    }
}
