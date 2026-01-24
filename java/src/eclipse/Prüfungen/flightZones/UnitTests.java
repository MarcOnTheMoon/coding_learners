package flightZones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTests {
	final private double DOUBLE_EPS_LOCATION = 0.01;	// Precision in comparison of double numbers
	final private double DOUBLE_EPS_DISTANCE = 1.0;	// Precision in comparison of double numbers

	@Test
	public final void test_Quadcopter_Getter() {
		String name = "SkyRider";
		double latitude = 53.71, longitude = 10.29;
		Quadcopter copter = new Quadcopter(name, latitude, longitude);

		assertEquals(name, copter.getName());
		assertEquals(latitude, copter.getLatitude(), DOUBLE_EPS_LOCATION);
		assertEquals(longitude, copter.getLongitude(), DOUBLE_EPS_LOCATION);
	}

	@Test
	public final void test_Quadcopter_setLocation() {
		String name = "SkyRider";
		double latitude = 53.71, longitude = 10.29;
		Quadcopter copter = new Quadcopter(name, 0.0, 0.0);
		
		copter.setLocation(latitude, longitude);
		assertEquals(latitude, copter.getLatitude(), DOUBLE_EPS_LOCATION);
		assertEquals(longitude, copter.getLongitude(), DOUBLE_EPS_LOCATION);
	}

	@Test
	public final void test_Location_GetterSetter() {
		double latitude = 53.71, longitude = 10.29;
		Location location = new Location(latitude, longitude);

		// Getter
		assertEquals(latitude, location.getLatitude(), DOUBLE_EPS_LOCATION);
		assertEquals(longitude, location.getLongitude(), DOUBLE_EPS_LOCATION);
		
		// Setter
		location.setLatitude(53.55);
		location.setLongitude(10.02);
		assertEquals(53.55, location.getLatitude(), DOUBLE_EPS_LOCATION);
		assertEquals(10.02, location.getLongitude(), DOUBLE_EPS_LOCATION);
	}

	@Test
	public final void test_Location_distance() {
		Location haw = new Location(53.557078, 10.023109);
		Location mainStation = new Location(53.552226, 10.008445);

		assertEquals(0.0, Location.distanceMeter(haw, haw), DOUBLE_EPS_DISTANCE);
		assertEquals(1109.8, Location.distanceMeter(haw, mainStation), DOUBLE_EPS_DISTANCE);
	}

	@Test
	public final void test_Zone_Getter() {
		String name = "Flight club";
		double latitude = 53.71, longitude = 10.29;
		Zone zone = new Zone(name, latitude, longitude);
		
		assertEquals(name, zone.getName());
	}

	@Test
	public final void test_Zone_compareTo() {
		Zone aa = new Zone("aa", 0.0, 0.0);
		Zone ab = new Zone("ab", 0.0, 0.0);

		assertEquals(-1, aa.compareTo(ab));
	}

	@Test
	public final void test_Zone_toString() {
		Zone haw = new Zone("HAW Hamburg", 0.0, 0.0);

		assertEquals("HAW Hamburg", haw.toString());
	}

	@Test
	public final void test_ZoneMap_AddContains() {
		ZoneMap map = new ZoneMap();
		Zone haw = new Zone("HAW Hamburg", 0.0, 0.0);

		map.addZone(haw);
		assertTrue(map.containsZone(haw));
	}

	@Test
	public final void test_ZoneMap_nearestZone() {
		ZoneMap map = new ZoneMap();
		Zone stGeorg = new Zone("Klinik St. Georg", 53.558954, 10.020080);
		Zone uke = new Zone("Uni-Klinik Eppendorf", 53.591176, 9.975552);

		// Create zone map
		map.addZone(stGeorg);
		map.addZone(uke);
		
		// Nearest zone
		Quadcopter copter = new Quadcopter("SkyRider", 53.557106, 10.023304);
		assertEquals(stGeorg, map.nearestZone(copter));
	}

	@Test
	public final void test_ZoneMap_toString() {
		ZoneMap map = new ZoneMap();
		Zone airport = new Zone("Flughafen", 0.0, 0.0);
		Zone haw = new Zone("HAW Hamburg", 0.0, 0.0);

		// Empty map
		String expected = "Map (0 flight zones):\n";
		assertEquals(expected, map.toString());
		
		// Add zone to map
		expected = "Map (1 flight zones):\n- Flughafen\n";
		map.addZone(airport);
		assertEquals(expected, map.toString());
		
		// Add zone to map
		expected = "Map (2 flight zones):\n- Flughafen\n- HAW Hamburg\n";
		map.addZone(haw);
		assertEquals(expected, map.toString());
	}	
}
