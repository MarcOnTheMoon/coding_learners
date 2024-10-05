package ai_bandit.lab2;

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
 * Version: 2024.05.07<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestMultiBanditSolver {
    private static final String packagePath = TestMultiBanditSolver.class.getPackage().getName() + ".";
    final private double DOUBLE_EPS = 0.000001;	        // Precision in comparison of double numbers

    private Map<String, Field> getAccessibleAttributes() throws NoSuchFieldException, SecurityException {
        Map<String, Field> map = new HashMap<>();

        map.put("random", MultiBanditSolver.class.getDeclaredField("random"));
        map.put("bandits", MultiBanditSolver.class.getDeclaredField("bandits"));
        map.put("counts", MultiBanditSolver.class.getDeclaredField("counts"));
        map.put("wins", MultiBanditSolver.class.getDeclaredField("wins"));
        map.put("epsilon", MultiBanditSolver.class.getDeclaredField("epsilon"));

        map.get("random").setAccessible(true);
        map.get("bandits").setAccessible(true);
        map.get("counts").setAccessible(true);
        map.get("wins").setAccessible(true);
        map.get("epsilon").setAccessible(true);

        return map;
    }

    @Test
    public final void test_R01_areVariablesPrivate() {
        assertTrue(areVariablesPrivate(packagePath + "MultiBanditSolver"));
    }

    @Test
    public final void test_R02_Constructor() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object
        int argNumberBandits = 6;
        MultiBandit argMultiBandit = new MultiBandit(argNumberBandits);
        MultiBanditSolver solver = new MultiBanditSolver(argMultiBandit);

        // Get attributes
        MultiBandit bandits = (MultiBandit) attributes.get("bandits").get(solver);
        int[] counts = (int[]) attributes.get("counts").get(solver);
        double[] wins = (double[]) attributes.get("wins").get(solver);
        double epsilon = (double) attributes.get("epsilon").get(solver);

        // Check attributes
        assertEquals(argMultiBandit, bandits);
        assertEquals(argNumberBandits, counts.length);
        assertEquals(argNumberBandits, wins.length);
        assertEquals(0.0, epsilon, DOUBLE_EPS);

        for (int i = 0; i < argNumberBandits; i++) {
            assertEquals(0, counts[i]);
            assertEquals(0.0, wins[i], DOUBLE_EPS);
        }
    }

    @Test
    public final void test_R03_SetGreedyEpsilon() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object
        int argNumberBandits = 6;
        MultiBandit argMultiBandit = new MultiBandit(argNumberBandits);
        MultiBanditSolver solver = new MultiBanditSolver(argMultiBandit);

        // Set attribute
        Random random = new Random();
        double eps = random.nextDouble();
        solver.setGreedyEpsilon(eps);

        // Check attribute
        double epsilon = (double) attributes.get("epsilon").get(solver);
        assertEquals(eps, epsilon, DOUBLE_EPS);
    }

    @Test
    public final void test_R04_AddBanditResponse() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object
        int argNumberBandits = 6;
        MultiBandit argMultiBandit = new MultiBandit(argNumberBandits);
        MultiBanditSolver solver = new MultiBanditSolver(argMultiBandit);

        // Get attributes
        int[] counts = (int[]) attributes.get("counts").get(solver);
        double[] wins = (double[]) attributes.get("wins").get(solver);

        // Add 1st bandit response and check attributes
        Random random = new Random();
        int index = random.nextInt(argNumberBandits);
        double win1 = random.nextDouble();
        solver.addBanditResponse(index, win1);
        assertEquals(1, counts[index]);
        assertEquals(win1, wins[index], DOUBLE_EPS);

        // Add 2nd bandit response and check attributes
        double win2 = random.nextDouble();
        solver.addBanditResponse(index, win2);
        assertEquals(2, counts[index]);
        assertEquals(win1 + win2, wins[index], DOUBLE_EPS);
    }

    @Test
    public final void test_R05_GetAverageWin()  {
        // Create object
        int argNumberBandits = 6;
        MultiBandit argMultiBandit = new MultiBandit(argNumberBandits);
        MultiBanditSolver solver = new MultiBanditSolver(argMultiBandit);

        // Check initial value
        Random random = new Random();
        int index = random.nextInt(argNumberBandits);
        assertEquals(0.0, solver.getAverageWin(index), DOUBLE_EPS);

        // Add 1st bandit response and check attribute
        double win1 = random.nextDouble();
        solver.addBanditResponse(index, win1);
        assertEquals(win1, solver.getAverageWin(index), DOUBLE_EPS);

        // Add 2nd bandit response and check attributes
        double win2 = random.nextDouble();
        double averageWin = (win1 + win2) / 2.0;
        solver.addBanditResponse(index, win2);
        assertEquals(averageWin, solver.getAverageWin(index), DOUBLE_EPS);
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
