package readability;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTests {
	final private double DOUBLE_EPS_SCORE = 0.01;	// Precision in comparison of double numbers

	@Test
	public final void test01_Statistics_Text() {
		TextStatistics statistics = new TextStatistics("We choose to go to the moon.");
		assertEquals("We choose to go to the moon.", statistics.getText());
	}

	@Test
	public final void test02_Statistics_Characters() {
		TextStatistics statistics = new TextStatistics("123456 abc");
		assertEquals(10, statistics.getCharacters());
	}

	@Test
	public final void test03_Statistics_Words() {
		TextStatistics statistics = new TextStatistics("Eins zwei drei.");
		assertEquals(3, statistics.getWords());

		statistics = new TextStatistics("Eins zwei drei. Vier fünf. Sechs!");
		assertEquals(6, statistics.getWords());
	}

	@Test
	public final void test04_Statistics_Sentences() {
		TextStatistics statistics = new TextStatistics("Eins zwei drei.");
		assertEquals(1, statistics.getSentences());

		statistics = new TextStatistics("Eins eins eins. Zwei zwei. Drei! Vier vier? Fünf; sechs.");
		assertEquals(6, statistics.getSentences());
	}

	@Test
	public final void test05_Statistics_Syllables() {
		// Single short word
		TextStatistics statistics1 = new TextStatistics("wer");
		TextStatistics statistics2 = new TextStatistics("an");
		assertEquals(1, statistics1.getSyllables());		
		assertEquals(1, statistics2.getSyllables());
		
		// Single words with vowels
		statistics1 = new TextStatistics("A_E__O___U____I___Ä__Ö_Ü");
		statistics2 = new TextStatistics("a_e__o___u____i___ä__ö_ü");
		assertEquals(8, statistics1.getSyllables());
		assertEquals(8, statistics2.getSyllables());
		
		// Single words with double vowels
		statistics1 = new TextStatistics("Au__ie__eu__oo__äu__e");
		statistics2 = new TextStatistics("_eie__oäü_");
		assertEquals(6, statistics1.getSyllables());
		assertEquals(2, statistics2.getSyllables());
		
		// Sum up syllables in text
		statistics1 = new TextStatistics("Heute ist perfektes Flugwetter. Super!");
		assertEquals(11, statistics1.getSyllables());
	}

	@Test
	public final void test06_Readability_Constructor() {
		ReadabilityScore score = new ReadabilityScore("We choose to go to the moon.");
		assertEquals("We choose to go to the moon.", score.getText());
	}

	@Test
	public final void test07_Readability_Score() {
		ReadabilityScore score = new ReadabilityScore(
				"Mücken nerven Leute, gestern, morgen, heute, auf der Suche nach Beute. "
				+ "Ihr Kopf ist so klein, da passt nur ein Gedanke rein. "
				+ "Sie wollen wissen: Hab' ich dich schon gebissen?");
		assertEquals(72.605, score.getScore(), DOUBLE_EPS_SCORE);
	}

	@Test
	public final void test08_Readability_toString() {
		String text = "Mücken nerven Leute.";

		ReadabilityScore score = new ReadabilityScore(text) { public double getScore() { return 95.0; } };
		assertEquals("95.0 (5. Klasse)", score.toString());
		
		score = new ReadabilityScore(text) { public double getScore() { return 89.9; } };
		assertEquals("89.9 (6. Klasse)", score.toString());
		
		score = new ReadabilityScore(text) { public double getScore() { return 80.03261; } };
		assertEquals("80.0 (6. Klasse)", score.toString());
		
		score = new ReadabilityScore(text) { public double getScore() { return 71.4; } };
		assertEquals("71.4 (7. Klasse)", score.toString());
		
		score = new ReadabilityScore(text) { public double getScore() { return 66.6; } };
		assertEquals("66.6 (8. - 9. Klasse)", score.toString());
		
		score = new ReadabilityScore(text) { public double getScore() { return 50.04; } };
		assertEquals("50.0 (10. - 13. Klasse)", score.toString());
		
		score = new ReadabilityScore(text) { public double getScore() { return 31.6; } };
		assertEquals("31.6 (Studierende)", score.toString());

		score = new ReadabilityScore(text) { public double getScore() { return 25.0; } };
		assertEquals("25.0 (Akademiker)", score.toString());
	}
}
