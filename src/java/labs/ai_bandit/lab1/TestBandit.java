package ai_bandit.lab1;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.03.18<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestBandit {
    private static final String packagePath = TestBandit.class.getPackage().getName() + ".";
    final private double DOUBLE_EPS = 0.000001;	        // Precision in comparison of double numbers

    private Map<String, Field> getAccessibleAttributes() throws NoSuchFieldException, SecurityException {
        Map<String, Field> map = new HashMap<>();

        map.put("random", Bandit.class.getDeclaredField("random"));
        map.put("name", Bandit.class.getDeclaredField("name"));
        map.put("pricePerRound", Bandit.class.getDeclaredField("pricePerRound"));
        map.put("averageWin", Bandit.class.getDeclaredField("averageWin"));
        map.put("stdDevWin", Bandit.class.getDeclaredField("stdDevWin"));
        map.put("overallProfit", Bandit.class.getDeclaredField("overallProfit"));
        map.put("roundsPlayed", Bandit.class.getDeclaredField("roundsPlayed"));

        map.get("random").setAccessible(true);
        map.get("name").setAccessible(true);
        map.get("pricePerRound").setAccessible(true);
        map.get("averageWin").setAccessible(true);
        map.get("stdDevWin").setAccessible(true);
        map.get("overallProfit").setAccessible(true);
        map.get("roundsPlayed").setAccessible(true);

        return map;
    }

    @Test
    public final void test_R01_areVariablesPrivate() {
        assertTrue(areVariablesPrivate(packagePath + "Bandit"));
    }

    @Test
    public final void test_R02_Random() throws Exception {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.81, 0.71);

        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Check random object
        assertTrue((attributes.get("random").get(bandit)) instanceof Random);
    }

    @Test
    public final void test_R03_Constructors() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object and check attributes
        Bandit bandit = new Bandit("My name", 1.49, 0.81, 0.71);
        assertEquals(attributes.get("name").get(bandit), "My name");
        assertEquals((double)attributes.get("pricePerRound").get(bandit), 1.49, DOUBLE_EPS);
        assertEquals((double)attributes.get("averageWin").get(bandit), 0.81, DOUBLE_EPS);
        assertEquals((double)attributes.get("stdDevWin").get(bandit), 0.71, DOUBLE_EPS);
        assertEquals((double)attributes.get("overallProfit").get(bandit), 0.0, DOUBLE_EPS);
        assertEquals((int)attributes.get("roundsPlayed").get(bandit), 0);

        // Create object using 2nd constructor and check attributes
        bandit = new Bandit(0.99, 0.81, 0.71);
        assertEquals((double)attributes.get("pricePerRound").get(bandit), 0.99, DOUBLE_EPS);
        assertEquals((double)attributes.get("averageWin").get(bandit), 0.81, DOUBLE_EPS);
        assertEquals((double)attributes.get("stdDevWin").get(bandit), 0.71, DOUBLE_EPS);
        assertEquals((double)attributes.get("overallProfit").get(bandit), 0.0, DOUBLE_EPS);
        assertEquals((int)attributes.get("roundsPlayed").get(bandit), 0);
    }

    @Test
    public final void test_R04_getName() throws Exception {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.81, 0.71);

        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Set attribute
        Field field = attributes.get("name");
        field.set(bandit, "A wonderful name");

        // Does getter return set value?
        assertEquals("A wonderful name", bandit.getName());
    }

    @Test
    public final void test_R04_getPricePerRound() throws Exception {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.81, 0.71);

        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Set attribute
        Field field = attributes.get("pricePerRound");
        field.set(bandit, 1.27);

        // Does getter return set value?
        assertEquals(1.27, bandit.getPricePerRound(), DOUBLE_EPS);
    }

    @Test
    public final void test_R04_getOverallProfit() throws Exception {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.81, 0.71);

        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Set attribute
        Field field = attributes.get("overallProfit");
        field.set(bandit, 41.66);

        // Does getter return set value?
        assertEquals(41.66, bandit.getOverallProfit(), DOUBLE_EPS);
    }

    @Test
    public final void test_R04_getRoundsPlayed() throws Exception {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.81, 0.71);

        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Set attribute
        Field field = attributes.get("roundsPlayed");
        field.set(bandit, 6);

        // Does getter return set value?
        assertEquals(6, bandit.getRoundsPlayed());
    }

    @Test
    public final void test_R05_getMeanProfitPerRound() throws Exception {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.81, 0.71);

        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Check initial value without played rounds
        assertEquals(0.0, bandit.getMeanProfitPerRound(), DOUBLE_EPS);

        // Set attributes
        Field field = attributes.get("overallProfit");
        field.set(bandit, 78.9);
        field = attributes.get("roundsPlayed");
        field.set(bandit, 10);

        // Does getter return correct value?
        assertEquals(78.9 / 10, bandit.getMeanProfitPerRound(), DOUBLE_EPS);
    }

    @Test
    public final void test_R06_play() {
        // Create object
        Bandit bandit = new Bandit(1.0, 0.8, 0.0);

        // Check initial values
        assertEquals(0.0, bandit.getOverallProfit(), DOUBLE_EPS);
        assertEquals(0, bandit.getRoundsPlayed());

        // Play two rounds and check updated values
        // (Note: Standard deviation is 0.0. => Win is mean value averageWin.)
        double win = bandit.play();
        double overallProfit = bandit.getPricePerRound() - win;
        assertEquals(0.8, win, DOUBLE_EPS);
        assertEquals(overallProfit, bandit.getOverallProfit(), DOUBLE_EPS);
        assertEquals(1, bandit.getRoundsPlayed());

        win = bandit.play();
        overallProfit += bandit.getPricePerRound() - win;
        assertEquals(0.8, win, DOUBLE_EPS);
        assertEquals(overallProfit, bandit.getOverallProfit(), DOUBLE_EPS);
        assertEquals(2, bandit.getRoundsPlayed());
    }

    /** Test if in class all modifiers of instance variables are "private".
     *
     * @param fullClassName Class name (including packages, e.g.: "histogram.Histogram")
     * @return True if all instance variables are private
     */
    public static boolean areVariablesPrivate(String fullClassName) {
        try {
            Class<?> c = Class.forName(fullClassName);
            Field[] fields = c.getDeclaredFields();

            for (Field f : fields) {
                int modifier = f.getModifiers();
                boolean isPrivate = (modifier & Modifier.PRIVATE) != 0;

                if (!isPrivate) {
                    return false;
                }
            }
            return true;
        } catch (ClassNotFoundException e) {
            fail("Class not found");
        }
        return false;
    }
}