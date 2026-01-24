package flight_connections;

import org.junit.Test;

import static org.junit.Assert.*;

/** Unit tests provided for the final exam E3-OP.
 *
 * @version SoSe 2025
 * @author Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">http://www.haw-hamburg.de/marc-hensel</a>)
 */
public class UnitTests {
	// Default values
	final private double DOUBLE_EPS = 0.001;	// Precision in comparison of double numbers

	@Test
	public final void test_01_GeoLocation_Getter() {
		GeoLocation hamburg = new GeoLocation(53.630389, 9.988228);

		assertEquals(53.630389, hamburg.getLatitude(), DOUBLE_EPS);
		assertEquals(9.988228, hamburg.getLongitude(), DOUBLE_EPS);
	}

	@Test
	public final void test_02_GeoLocation_Distance() {
		GeoLocation hamburg = new GeoLocation(53.630389, 9.988228);
		GeoLocation frankfurt = new GeoLocation(50.033306, 8.570456);

		assertEquals(0.0, GeoLocation.distanceInKm(frankfurt, frankfurt), DOUBLE_EPS);
		assertEquals(412.1258904607585, GeoLocation.distanceInKm(hamburg, frankfurt), DOUBLE_EPS);
	}

	@Test
	public final void test_03_Airport_Getter() {
		Airport hamburg = new Airport("Hamburg", 53.630389, 9.988228);

		assertEquals("Hamburg", hamburg.getName());
	}

	@Test
	public final void test_04_Airport_SuperClass() {
		Airport hamburg = new Airport("Hamburg", 53.630389, 9.988228);

		assertEquals(53.630389, hamburg.getLatitude(), DOUBLE_EPS);
		assertEquals(9.988228, hamburg.getLongitude(), DOUBLE_EPS);
	}

	@Test
	public final void test_05_FlightConnection_Getter() {
		Airport hamburg = new Airport("Hamburg", 53.630389, 9.988228);
		Airport frankfurt = new Airport("Frankfurt/Main", 50.033306, 8.570456);
		FlightConnection flight = new FlightConnection(hamburg, frankfurt);

		assertEquals(hamburg, flight.getDeparture());
		assertEquals(frankfurt, flight.getDestination());
	}

	@Test
	public final void test_06_FightConnection_Distance() {
		Airport hamburg = new Airport("Hamburg", 53.630389, 9.988228);
		Airport frankfurt = new Airport("Frankfurt/Main", 50.033306, 8.570456);
		FlightConnection flight = new FlightConnection(frankfurt, hamburg);

		assertEquals(412.1258904607585, flight.getDistanceKm(), DOUBLE_EPS);
	}

	@Test
	public final void test_07_FightConnection_toString() {
		Airport hamburg = new Airport("Hamburg", 53.630389, 9.988228);
		Airport frankfurt = new Airport("Frankfurt/Main", 50.033306, 8.570456);
		FlightConnection flight = new FlightConnection(hamburg, frankfurt);

		String actual = flight.toString();
		actual = actual.replace(',', '.');
		assertEquals("Hamburg to Frankfurt/Main (412.1 km)", actual);
	}

	@Test
	public final void test_08_FightConnection_compareTo() {
		Airport hamburg = new Airport("Hamburg",53.630389, 9.988228);
		Airport frankfurt = new Airport("Frankfurt/Main", 50.033306, 8.570456);
		Airport saoPaulo = new Airport("Sao Paulo", -23.432075, -46.469511);
		FlightConnection hamburgFrankfurt = new FlightConnection(hamburg, frankfurt);
		FlightConnection frankfurtHamburg = new FlightConnection(hamburg, frankfurt);
		FlightConnection frankfurtSaoPaulo = new FlightConnection(frankfurt, saoPaulo);

		assertEquals(-1, frankfurtHamburg.compareTo(frankfurtSaoPaulo));
		assertEquals(1, frankfurtSaoPaulo.compareTo(frankfurtHamburg));
		assertEquals(0, frankfurtHamburg.compareTo(hamburgFrankfurt));
	}

	@Test
	public final void test_09_NotOnEarthException_Message() {
		NotOnEarthException exception = new NotOnEarthException("Location is not on earth");

		assertEquals("Location is not on earth", exception.getMessage());
	}

	@Test
	public final void test_10_NotOnEarthException_Thrown() {
		boolean isExceptionThrown = false;

		try {
			new GeoLocation(500.0, 500.0);
		} catch (NotOnEarthException e) {
			isExceptionThrown = true;
		}
		assertTrue(isExceptionThrown);
	}
}
