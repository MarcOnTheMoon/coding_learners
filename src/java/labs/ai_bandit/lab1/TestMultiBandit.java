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
public class TestMultiBandit {
    private static final String packagePath = TestMultiBandit.class.getPackage().getName() + ".";
    final private double DOUBLE_EPS = 0.000001;	        // Precision in comparison of double numbers

    private Map<String, Field> getAccessibleAttributes() throws NoSuchFieldException, SecurityException {
        Map<String, Field> map = new HashMap<>();

        map.put("bandits", MultiBandit.class.getDeclaredField("bandits"));
        map.get("bandits").setAccessible(true);

        return map;
    }

    @Test
    public final void test_R01_areVariablesPrivate() {
        assertTrue(areVariablesPrivate(packagePath + "MultiBandit"));
    }

    @Test
    public final void test_R02_Constructor() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object and check attribute
        MultiBandit multiBandit = new MultiBandit(6);
        Bandit[] bandits = (Bandit[])attributes.get("bandits").get(multiBandit);
        assertEquals(6, bandits.length);
    }

    @Test
    public final void test_R04_getNumberBandits() {
        // Create object and check getter
        MultiBandit multiBandit = new MultiBandit(16);
        assertEquals(16, multiBandit.getNumberBandits());
    }

    @Test
    public final void test_R04_getPricePerRound() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object and check getter
        MultiBandit multiBandit = new MultiBandit(7);
        Bandit[] bandits = (Bandit[])attributes.get("bandits").get(multiBandit);

        for (Bandit bandit : bandits)
            assertEquals(1.0, bandit.getPricePerRound(), DOUBLE_EPS);
    }

    @Test
    public final void test_R04_getOverallProfit() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object and check initial value
        int numberBandits = 7;
        MultiBandit multiBandit = new MultiBandit(numberBandits);
        assertEquals(0.0, multiBandit.getOverallProfit(), DOUBLE_EPS);

        // Play some rounds and check value
        Bandit[] bandits = (Bandit[])attributes.get("bandits").get(multiBandit);
        double overallProfit = 0.0;

        for (int i = 0; i < 26; i++)
            multiBandit.play(new Random().nextInt(numberBandits));
        for (Bandit bandit : bandits)
            overallProfit += bandit.getOverallProfit();

        assertEquals(overallProfit, multiBandit.getOverallProfit(), DOUBLE_EPS);
    }

    @Test
    public final void test_R04_getMeanProfitPerRound() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object and check initial value
        int numberBandits = 5;
        MultiBandit multiBandit = new MultiBandit(numberBandits);
        assertEquals(0.0, multiBandit.getMeanProfitPerRound(), DOUBLE_EPS);

        // Play some rounds and check value
        Bandit[] bandits = (Bandit[])attributes.get("bandits").get(multiBandit);
        double overallProfit = 0.0;
        int numberRounds = 32;

        for (int i = 0; i < numberRounds; i++)
            multiBandit.play(new Random().nextInt(numberBandits));
        for (Bandit bandit : bandits)
            overallProfit += bandit.getOverallProfit();

        assertEquals(overallProfit / numberRounds, multiBandit.getMeanProfitPerRound(), DOUBLE_EPS);
    }

    @Test
    public final void test_R04_getRoundsPlayed() {
        // Create object and check initial value
        int numberBandits = 6;
        MultiBandit multiBandit = new MultiBandit(numberBandits);
        assertEquals(0, multiBandit.getRoundsPlayed());

        // Play some rounds and check value
        int numberRounds = 32;

        for (int i = 0; i < numberRounds; i++)
            multiBandit.play(new Random().nextInt(numberBandits));

        assertEquals(numberRounds, multiBandit.getRoundsPlayed());
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
