package ai_bandit.lab2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.05.24<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestWheelOfFortune {
    private static final String packagePath = TestWheelOfFortune.class.getPackage().getName() + ".";
    final private double DOUBLE_EPS = 0.000001;	        // Precision in comparison of double numbers

    private Map<String, Field> getAccessibleAttributes() throws NoSuchFieldException, SecurityException {
        Map<String, Field> map = new HashMap<>();

        map.put("numberFields", WheelOfFortune.class.getDeclaredField("numberFields"));
        map.put("categoryWins", WheelOfFortune.class.getDeclaredField("categoryWins"));
        map.put("categoryChances", WheelOfFortune.class.getDeclaredField("categoryChances"));

        map.get("numberFields").setAccessible(true);
        map.get("categoryWins").setAccessible(true);
        map.get("categoryChances").setAccessible(true);

        return map;
    }

    @Test
    public final void test_R07_areVariablesPrivate() {
        assertTrue(areVariablesPrivate(packagePath + "WheelOfFortune"));
    }

    @Test
    public final void test_R08_Constructor() throws Exception {
        // Make attributes accessible
        Map<String, Field> attributes = getAccessibleAttributes();

        // Create object
        int[] argCategoryNumberFields = { 1, 2 };
        double[] argCategoryWins = { 1.5, 2.5 };
        int argNumberFields = 3;
        int argNumberCategories = 2;
        WheelOfFortune wheel = new WheelOfFortune(1.0, argCategoryNumberFields, argCategoryWins);

        // Get attributes
        int numberFields = (int) attributes.get("numberFields").get(wheel);
        double[] categoryWins = (double[]) attributes.get("categoryWins").get(wheel);
        double[] categoryChances = (double[]) attributes.get("categoryChances").get(wheel);

        // Check attributes
        assertEquals(argNumberFields, numberFields);
        assertEquals(argNumberCategories, categoryWins.length);
        assertEquals(argNumberCategories, categoryChances.length);

        for (int i = 0; i < argNumberCategories; i++) {
            assertEquals(argCategoryWins[i], categoryWins[i], DOUBLE_EPS);
            assertEquals(argCategoryNumberFields[i] / (double)argNumberFields, categoryChances[i], DOUBLE_EPS);
        }
    }

    @Test
    public final void test_R09_GetNumberFields() {
        // Create object
        int minRange = 1, maxRange = 30;
        Random random = new Random();
        int numberFields1 = random.nextInt(maxRange - minRange + 1) + minRange;
        int numberFields2 = random.nextInt(maxRange - minRange + 1) + minRange;
        int argNumberFields = numberFields1 + numberFields2;
        int[] argCategoryNumberFields = { numberFields1, numberFields2 };
        WheelOfFortune wheel = new WheelOfFortune(1.0, argCategoryNumberFields, new double[]{ 1.5, 2.5 });

        // Check method
        assertEquals(argNumberFields, wheel.getNumberFields());
    }

    @Test
    public final void test_R10_DetermineWin() {
        // Create object
        Random random = new Random();
        double argWin = random.nextDouble();
        int[] argCategoryNumberFields = { 10, 20, 30 };
        double[] argCategoryWins = { argWin, argWin, argWin };
        WheelOfFortune wheel = new WheelOfFortune(1.0, argCategoryNumberFields, argCategoryWins);

        // Check method
        assertEquals(argWin, wheel.determineWin(), DOUBLE_EPS);
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
