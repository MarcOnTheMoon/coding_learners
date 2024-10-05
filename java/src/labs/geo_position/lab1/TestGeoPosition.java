package geo_position.lab1;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestGeoPosition {
	private static final String packagePath = TestGeoPosition.class.getPackage().getName() + ".";
	final private double DOUBLE_EPS_POSITION = 0.000001;	// Precision in comparison of double numbers
	final private double DOUBLE_EPS_DISTANCE = 0.1;			// Precision in comparison of double numbers

	@Test
	public final void test_R01_areVariablesPrivate() {
		assertTrue(areVariablesPrivate(packagePath + "GeoPosition"));
	}

	@Test
	public void test_R02_R03_Getters() {
		double latitude = 53.557078;
		double longitude = 10.023109;
		GeoPosition haw = new GeoPosition(latitude, longitude);

		assertEquals(latitude, haw.getLatitude(), DOUBLE_EPS_POSITION);
		assertEquals(longitude, haw.getLongitude(), DOUBLE_EPS_POSITION);
	}

	@Test
	public void test_R04_Hemispheres() {
		GeoPosition a = new GeoPosition(-0.0001, 0.0);
		assertFalse(a.isNorthernHemisphere());
		assertTrue(a.isSouthernHemisphere());

		GeoPosition b = new GeoPosition(0.0001, 0.0);
		assertTrue(b.isNorthernHemisphere());
		assertFalse(b.isSouthernHemisphere());
	}

	@Test
	public void test_R05_R06_Distance() {
		GeoPosition haw = new GeoPosition(53.557078, 10.023109);
		GeoPosition mainStation = new GeoPosition(53.552226, 10.008445);
		GeoPosition harbor = new GeoPosition(53.545114, 9.971833);
		GeoPosition airport = new GeoPosition(53.632349, 10.006661);

		assertEquals(1.1, GeoPosition.localDistanceInKm(haw, mainStation), DOUBLE_EPS_DISTANCE);
		assertEquals(3.6, GeoPosition.localDistanceInKm(haw, harbor), DOUBLE_EPS_DISTANCE);
		assertEquals(8.4, GeoPosition.localDistanceInKm(haw, airport), DOUBLE_EPS_DISTANCE);

		assertEquals(1.1, GeoPosition.distanceInKm(haw, mainStation), DOUBLE_EPS_DISTANCE);
		assertEquals(3.6, GeoPosition.distanceInKm(haw, harbor), DOUBLE_EPS_DISTANCE);
		assertEquals(8.4, GeoPosition.distanceInKm(haw, airport), DOUBLE_EPS_DISTANCE);

		assertEquals(1.1, haw.distanceInKm(mainStation), DOUBLE_EPS_DISTANCE);
		assertEquals(3.6, haw.distanceInKm(harbor), DOUBLE_EPS_DISTANCE);
		assertEquals(8.4, haw.distanceInKm(airport), DOUBLE_EPS_DISTANCE);
	}

	@Test
	public void test_R07_toString() {
		GeoPosition a = new GeoPosition(1.5, 2.7);
		GeoPosition b = new GeoPosition(1.5, -2.7);
		GeoPosition c = new GeoPosition(-1.5, 2.7);
		GeoPosition d = new GeoPosition(-1.5, -2.7);

		assertEquals("(1.5, 2.7)", a.toString());
		assertEquals("(1.5, -2.7)", b.toString());
		assertEquals("(-1.5, 2.7)", c.toString());
		assertEquals("(-1.5, -2.7)", d.toString());
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
