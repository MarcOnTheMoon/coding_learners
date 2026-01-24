package formula1;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.*;

public class RacingTest {

	@Test
	public final void testR3Person_getFirstName() {
		Person person = new Person("Sebastian", "Vettel");
		assertEquals("Sebastian", person.getFirstName());
	}

	@Test
	public final void testR3Person_getSurname() {
		Person person = new Person("Sebastian", "Vettel");
		assertEquals("Vettel", person.getSurname());
	}

	@Test
	public final void testR7Driver_getRacingTeam() {
		RacingTeam team = new RacingTeam("Red Bull");
		Driver driver = new Driver("Sebastian", "Vettel", team);
		assertSame(team, driver.getRacingTeam());
	}

	@Test
	public final void testR9Driver_getGrandPrixPoints() {
		RacingTeam team = new RacingTeam("Red Bull");
		Driver driverDummy = new Driver("Mark", "Webber", team);
		Driver[] drivers = new Driver[10];

		// Fill driver finish with dummy object
		for (int i = 0; i < drivers.length; i++) {
			drivers[i] = driverDummy;
		}

		// Add races with driver at position 1, 2, 3, ..., 10
		for (int position = 1; position <= 10; position++) {
			Driver driver = new Driver("Sebastian", "Vettel", team);

			// Set driver at correct position in driver array
			drivers[position - 1] = driver;

			// Create race results (will add race to driver object)
			@SuppressWarnings("unused")
			RaceResult race = new RaceResult("GP", drivers);

			int[] pointLUT = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
			assertEquals(pointLUT[position - 1], driver.getGrandPrixPoints());

			// Remove driver from driver array
			drivers[position - 1] = driverDummy;
		}
	}

	@Test
	public final void testR10Driver_SortingDescending() {
		RacingTeam team = new RacingTeam("Red Bull");
		Driver vettel = new Driver("Sebastian", "Vettel", team);
		Driver webber = new Driver("Mark", "Webber", team);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		
		drivers.add(vettel);
		drivers.add(webber);
		
		// Vettel: 0 / Webber: 25 points (Test 'smaller')
		@SuppressWarnings("unused")
		RaceResult race = new RaceResult("GP", new Driver[]{webber});
		Collections.sort(drivers);
		assertSame(webber, drivers.get(0));
		assertSame(vettel, drivers.get(1));
		
		// Vettel: 25 / Webber: 25 points (Test 'equal')
		race = new RaceResult("GP", new Driver[]{vettel});
		Collections.sort(drivers);
		assertSame(webber, drivers.get(0));
		assertSame(vettel, drivers.get(1));
		
		// Vettel: 50 / Webber: 43 points (Test 'greater')
		race = new RaceResult("GP", new Driver[]{vettel, webber});
		Collections.sort(drivers);
		assertSame(vettel, drivers.get(0));
		assertSame(webber, drivers.get(1));
	}
	
	@Test
	public final void testR13Team_getName() {
		RacingTeam team = new RacingTeam("Red Bull");
		assertEquals("Red Bull", team.getName());
	}

	@Test
	public final void testR14Team_getDrivers() {
		// Note: Constructor Driver() calls RacingTeam::addDriver()
		RacingTeam team = new RacingTeam("Red Bull");
		Driver driver1 = new Driver("Sebastian", "Vettel", team);
		Driver driver2 = new Driver("Mark", "Webber", team);
		
		// Get drivers
		Driver[] driversOut = team.getDrivers();
		assertEquals(2, driversOut.length);
		assertSame(driver1, driversOut[0]);
		assertSame(driver2, driversOut[1]);
	}

	@Test
	public final void testR15Team_addDriver() {
		// Note: Constructor Driver() calls RacingTeam::addDriver()
		RacingTeam team = new RacingTeam("Red Bull");
		Driver driver1 = new Driver("Sebastian", "Vettel", team);
		Driver driver2 = new Driver("Mark", "Webber", team);
		
		// Add duplicates (should not change anything)
		team.addDriver(driver1);
		assertSame(2, team.getDrivers().length);
		team.addDriver(driver2);
		assertSame(2, team.getDrivers().length);
	}

	@Test
	public final void testR18Race_ExceptionThrown() {
		boolean isExceptionThrown = false;
		
		try {
			@SuppressWarnings("unused")
			RaceResult race = new RaceResult("GP", new Driver[0]);
		} catch (RuntimeException e) {
			isExceptionThrown = true;
		}
		assertEquals(true, isExceptionThrown);
	}

	@Test
	public final void testR19Race_getName() {
		RacingTeam team = new RacingTeam("Red Bull");
		Driver driver = new Driver("Sebastian", "Vettel", team);
		RaceResult race = new RaceResult("GP", new Driver[]{driver});
		assertEquals("GP", race.getName());
	}

	@Test
	public final void testR20Race_getDriverPoints() {
		int[] pointLUT = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
		RacingTeam team = new RacingTeam("Red Bull");
		Driver[] drivers = new Driver[11];

		// Create array with 11 different drivers
		for (int i = 0; i < 11; i++) {
			drivers[i] = new Driver("New", "Driver", team);
		}

		// Create race => RaceResult object will be referenced by all drivers in array
		RaceResult race = new RaceResult("GP", drivers);
		
		// Assert correct points for all drivers (dpending on position in array)
		for (int i = 0; i < 10; i++) {
			assertEquals(pointLUT[i], race.getDriverPoints(drivers[i]));
		}
		assertEquals(0, race.getDriverPoints(drivers[10]));
		assertEquals(0, race.getDriverPoints(new Driver("Sebastian", "Vettel", team)));
	}

	@Test
	public final void testR24Season_addRaceResults() {
		RacingTeam team = new RacingTeam("Red Bull");
		Driver driver = new Driver("Sebastian", "Vettel", team);
		RaceResult race1 = new RaceResult("GP", new Driver[]{driver, driver});
		RaceResult race2 = new RaceResult("GP", new Driver[]{driver, driver, driver});
		RacingSeason season = new RacingSeason();
		
		// Add (no duplicates)
		season.addRaceResults(race1);
		season.addRaceResults(race2);
		RaceResult[] races = season.getRaces();
		assertSame(race1, races[0]);
		assertSame(race2, races[1]);
		
		// Add duplicates (should not change anything)
		season.addRaceResults(race1);
		assertSame(2, season.getRaces().length);
		season.addRaceResults(race2);
		assertSame(2, season.getRaces().length);
	}

	@Test
	public final void testR26Season_getDriverRanking() {
		RacingTeam redBull = new RacingTeam("Red Bull Racing");
		RacingTeam virgin = new RacingTeam("Virgin Racing");
		Driver vettel = new Driver("Sebastian", "Vettel", redBull);
		Driver glock = new Driver("Timo", "Glock", virgin);
		RacingSeason season = new RacingSeason();
		
		season.addTeam(redBull);
		season.addTeam(virgin);
				
		// Vettel: 25, Glock: 18 points
		ArrayList<RaceResult> races = new ArrayList<RaceResult>();
		races.add(new RaceResult("GP", new Driver[]{vettel, glock}));
		Driver[] driverRanking = season.getDriverRanking();
		assertSame(vettel, driverRanking[0]);
		assertSame(glock, driverRanking[1]);
		
		// Vettel: 25, Glock: 43 points
		races.add(new RaceResult("GP", new Driver[]{glock}));
		driverRanking = season.getDriverRanking();
		assertSame(glock, driverRanking[0]);
		assertSame(vettel, driverRanking[1]);
	}	
}
