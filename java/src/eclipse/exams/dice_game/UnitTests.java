package dice_game;

import org.junit.Test;

import static org.junit.Assert.*;

/** Unit tests provided for the final exam E3-OP.
 *
 * @version SoSe 2023
 * @author Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">http://www.haw-hamburg.de/marc-hensel</a>)
 */
public class UnitTests {

	@Test
	public final void test_01_Dice_NumberDice() {
		int numberDice = 7;
		Dice dice = new Dice(numberDice);

		// Assert
		assertEquals(numberDice, dice.getNumberDice());
	}

	@Test
	public final void test_02_Dice_NumberCount() {
		int numberDice = 6;
		Dice dice = new Dice(numberDice);

		// Get rolled numbers
		int[] rolledNumbers = new int[dice.getNumberDice()];
		for (int i = 0; i < dice.getNumberDice(); i++) {
			rolledNumbers[i] = dice.getRolledNumber(i);
		}

		// Count numbers and assert
		for (int number = 1; number <= 6; number++) {
			int count = 0;
			for (int rolledNumber : rolledNumbers) {
				if (rolledNumber == number)
					count++;
			}
			assertEquals(count, dice.getNumberCount(number));
		}
	}
	
	@Test
	public final void test_03_Dice_RollRandom() {
		int numberDice = 3;
		Dice dice = new Dice(numberDice);

		// Get rolled numbers
		int[] rolledNumbers = {dice.getRolledNumber(0), dice.getRolledNumber(1), dice.getRolledNumber(2)};

		// Check that rolled numbers change by rolling
		boolean[] isChanged = {false, false, false};
		for (int i = 0; i < 100; i++) {
			dice.roll();

			for (int index = 0; index < numberDice; index++) {
				if (dice.getRolledNumber(index) != rolledNumbers[index])
					isChanged[index] = true;
			}
		}

		// Assert
		for (int index = 0; index < numberDice; index++) {
			assertTrue(isChanged[index]);
		}
	}

	@Test
	public final void test_04_Scorecard_Constructor_Getter() {
		Scorecard scorecard = new Scorecard();

		// Assert empty fields with score 0
		for (int field = 1; field <= 6; field++) {
			assertTrue(scorecard.isScoreFieldEmpty(field));
			assertEquals(0, scorecard.getScoreField(field));
		}
	}

	@Test
	public final void test_05_Scorecard_Setter_Score_Reset() {
		Scorecard scorecard = new Scorecard();
		int score = 0;

		// Set fields and assert non-empty fields with correct points
		for (int field = 1; field <= 6; field++) {
			scorecard.setScoreField(field, 4);
			score += 4 * field;

			assertFalse(scorecard.isScoreFieldEmpty(field));
			assertEquals(4 * field, scorecard.getScoreField(field));
		}

		// Assert overall score
		assertEquals(score, scorecard.getScore());

		// Reset and assert empty fields with 0 points
		scorecard.reset();
		for (int field = 1; field <= 6; field++) {
			assertTrue(scorecard.isScoreFieldEmpty(field));
			assertEquals(0, scorecard.getScoreField(field));
		}
	}

	@Test
	public final void test_06_Game_Constructor_Getter() {
		Game game = new Game();

		// Assert data types
		assertEquals(Dice.class, game.getDice().getClass());
		assertEquals(Scorecard.class, game.getScorecard().getClass());

		// Assert values
		assertEquals(5, game.getDice().getNumberDice());
		assertEquals(0, game.getScorecard().getScore());
	}

	@Test
	public final void test_07_Game_SelectField_NewGame() {
		Game game = new Game();
		Dice dice = game.getDice();
		Scorecard scorecard = game.getScorecard();

		// Select field and assert score > 0
		int rolledNumber = dice.getRolledNumber(0);
		game.selectFieldAndRoll(rolledNumber);
		assertTrue(scorecard.getScore() > 0);

		// Assert new game sets score to o
		game.newGame();
		assertEquals(0, scorecard.getScore());
	}

	@Test
	public final void test_08_FieldNotEmptyException() {
		Scorecard scorecard = new Scorecard();

		for (int field = 1; field <= 6; field++) {
			boolean isException = false;

			// Assert exception thrown when selecting field  twice
			scorecard.setScoreField(field, 2);
			try {
				scorecard.setScoreField(field, 0);
			} catch (FieldNotEmptyException e) {
				isException = true;
			}
			assertTrue(isException);
		}
	}
}
