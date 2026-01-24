package readability;

public class ReadabilityDemo {

	public static void main(String[] args) {
		// Laing, Mücken nerven Leute
		String laing
				= "Ich lieg' hier schön in meinem Bett. Es ist warm, es ist nett. "
				+ "Gleich schlaf' ich ein, perfekt. Da fängt es an weit weg. "
				+ "Sssssss, laut wie ein Hubschrauber. Ein kleiner Blutsauger unterwegs zum Arbeitsplatz. "
				+ "Und dreimal darfst du raten, was 'ne Mücke beruflich macht. "
				+ "Mücken nerven Leute, gestern, morgen, heute, sssssss, auf der Suche nach Beute. "
				+ "Ihr Kopf ist so klein, da passt nur ein Gedanke rein. "
				+ "Sie wollen wissen: Hab' ich dich schon gebissen? "
				+ "Na toll! Ich hab' die Schnauze voll. Jetzt wird die Zeitung gerollt.";

		// John F. Kennedy, The Decision to go the Moon (1961)
		String moon = "We choose to go to the moon. "
				+ "We choose to go to the moon in this decade and do the other things, not because they are easy, but because they are hard, "
				+ "because that goal will serve to organize and measure the best of our energies and skills, "
				+ "because that challenge is one that we are willing to accept, one we are unwilling to postpone, "
				+ "and one which we intend to win, and the others, too.";

		// Determine text properties
		ReadabilityScore scoreLiang = new ReadabilityScore(laing);
		ReadabilityScore scoreMoon = new ReadabilityScore(moon);
		
		// Display results
		System.out.printf("Text    | Zeichen | Wörter | Sätze | Silben | Lesbarkeit\n");
		System.out.printf("Liang   | %7d | %6d | %5d | %6d | %s\n",
				scoreLiang.getCharacters(),
				scoreLiang.getWords(),
				scoreLiang.getSentences(),
				scoreLiang.getSyllables(),
				scoreLiang);
		System.out.printf("Kennedy | %7d | %6d | %5d | %6d | %s\n",
				scoreMoon.getCharacters(),
				scoreMoon.getWords(),
				scoreMoon.getSentences(),
				scoreMoon.getSyllables(),
				scoreMoon);
	}
}
