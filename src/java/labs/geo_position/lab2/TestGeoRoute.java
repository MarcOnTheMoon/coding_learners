package geo_position.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestGeoRoute {
	private static final String packagePath = TestGeoRoute.class.getPackage().getName() + ".";
	final private double DOUBLE_EPS_DISTANCE = 0.1;			// Precision in comparison of double numbers

	@Test
	public final void test_areVariablesPrivate() {
		assertTrue(areVariablesPrivate(packagePath + "GeoRoute"));
		assertTrue(areVariablesPrivate(packagePath + "GeoTrack"));
	}

	@Test
	public void test_GeoRoute_name() {
		// Constructor and getter
		GeoRoute route = new GeoRoute("Airport");
		assertEquals("Airport", route.getName());

		// Setter and getter
		route.setName("HAW Hamburg");
		assertEquals("HAW Hamburg", route.getName());
	}

	@Test
	public void test_GeoRoute_waypoints() {
		GeoPosition haw = new GeoPosition(53.556350, 10.021552);
		GeoPosition airport = new GeoPosition(53.633060, 9.993501);

		// Initially empty list
		GeoRoute route = new GeoRoute("Airport");
		assertEquals(0, route.getNumberWaypoints());
		assertEquals(0, route.getWaypoints().length);

		// Add waypoint => 1 in list
		route.addWaypoint(haw);
		assertEquals(1, route.getNumberWaypoints());
		assertEquals(1, route.getWaypoints().length);
		assertEquals(haw, route.getWaypoint(0));
		assertEquals(haw, route.getWaypoints()[0]);

		// Add waypoint => 2 in list
		route.addWaypoint(airport);
		assertEquals(2, route.getNumberWaypoints());
		assertEquals(2, route.getWaypoints().length);
		assertEquals(haw, route.getWaypoint(0));
		assertEquals(haw, route.getWaypoints()[0]);
		assertEquals(airport, route.getWaypoint(1));
		assertEquals(airport, route.getWaypoints()[1]);

		// Remove waypoint => 1 in list
		route.removeWaypoint(0);
		assertEquals(1, route.getNumberWaypoints());
		assertEquals(1, route.getWaypoints().length);
		assertEquals(airport, route.getWaypoint(0));
		assertEquals(airport, route.getWaypoints()[0]);

		// Remove waypoint => Empty list
		route.removeWaypoint(0);
		assertEquals(0, route.getNumberWaypoints());
		assertEquals(0, route.getWaypoints().length);

		// Try to remove waypoint from empty list
		route.removeWaypoint(0);
		assertEquals(0, route.getNumberWaypoints());
		assertEquals(0, route.getWaypoints().length);
	}

	@SuppressWarnings("unused")
	@Test
	public void test_GeoRoute_implementsInterfaces() {
		Distance distanceRef = new GeoRoute("Airport");
		Comparable<GeoRoute> comparableRef = new GeoRoute("Airport");
	}

	@Test
	public void test_GeoRoute_distance() {
		GeoPosition haw = new GeoPosition(53.556350, 10.021552);
		GeoPosition airport = new GeoPosition(53.633060, 9.993501);
		double distance = 8.7385;

		// Initially empty list
		GeoRoute route = new GeoRoute("Airport");
		assertEquals(0.0, route.getDistance(), DOUBLE_EPS_DISTANCE);

		// Add 1st waypoint
		route.addWaypoint(haw);
		assertEquals(0.0, route.getDistance(), DOUBLE_EPS_DISTANCE);

		// Add 2nd waypoint
		route.addWaypoint(airport);
		assertEquals(distance, route.getDistance(), DOUBLE_EPS_DISTANCE);

		// Add 2nd waypoint (round trip)
		route.addWaypoint(haw);
		assertEquals(2.0 * distance, route.getDistance(), DOUBLE_EPS_DISTANCE);
	}

	@Test
	public void test_GeoRoute_comparable() {
		GeoPosition hamburg = new GeoPosition(53.633060, 9.993501);
		GeoPosition billund = new GeoPosition(55.740806, 9.152466);
		GeoPosition amsterdam = new GeoPosition(52.310480, 4.767684);
		GeoPosition lyon = new GeoPosition(45.720407, 5.081052);
		GeoRoute billundRoute = new GeoRoute("Billund", new ArrayList<>(Arrays.asList(hamburg, billund)));
		GeoRoute amsterdamRoute = new GeoRoute("Amsterdam", new ArrayList<>(Arrays.asList(hamburg, amsterdam)));
		GeoRoute lyonRoute = new GeoRoute("Lyon", new ArrayList<>(Arrays.asList(hamburg, lyon)));

		// Distances
		assertEquals(240.80, billundRoute.getDistance(), DOUBLE_EPS_DISTANCE);
		assertEquals(379.90, amsterdamRoute.getDistance(), DOUBLE_EPS_DISTANCE);
		assertEquals(948.73, lyonRoute.getDistance(), DOUBLE_EPS_DISTANCE);

		// Sort
		ArrayList<GeoRoute> routes = new ArrayList<>(Arrays.asList(lyonRoute, amsterdamRoute, billundRoute));
		Collections.sort(routes);
		assertEquals(billundRoute, routes.get(0));
		assertEquals(amsterdamRoute, routes.get(1));
		assertEquals(lyonRoute, routes.get(2));
	}

	@Test
	public void test_GeoRoute_toString() {
		GeoPosition haw = new GeoPosition(53.556350, 10.021552);
		GeoPosition airport = new GeoPosition(53.633060, 9.993501);
		double distance = 8.7385;

		// Create route
		GeoRoute route = new GeoRoute("Airport");
		route.addWaypoint(haw);
		route.addWaypoint(airport);

		// Assert toString() method
		String expected = String.format("%s (%.1f km)", route.getName(), distance);
		assertEquals(expected, route.toString());
	}

	@SuppressWarnings("unused")
	@Test
	public void test_GeoTrack_superClass() {
		GeoRoute alster = new GeoTrack("Alster", "2016-08-08");
	}

	@Test
	public void test_GeoTrack_GetterSetter() {
		GeoTrack alster = new GeoTrack("Alster", "2016-08-08");

		// Construtor and getters
		assertEquals("Alster", alster.getName());
		assertEquals("2016-08-08", alster.getDate());

		// Date
		alster.setDate("2016-09-01");
		assertEquals("2016-09-01", alster.getDate());
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
