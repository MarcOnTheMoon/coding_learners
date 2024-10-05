package geo_position.lab2;

import java.util.ArrayList;
import java.util.Arrays;

/** Sample solution for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class RouteData {
	public static GeoRoute createAlsterRoute1() {
		GeoRoute route = new GeoRoute("Binnenalster");

		route.addWaypoint(new GeoPosition(53.556350, 10.021552));	// HAW
		route.addWaypoint(new GeoPosition(53.561181, 10.013452));	// Alster (Lohmühlenstraße)
		route.addWaypoint(new GeoPosition(53.557744, 10.004890));	// Alstertwiete
		route.addWaypoint(new GeoPosition(53.559162, 9.995711));	// Kennedybrücke
		route.addWaypoint(new GeoPosition(53.554451, 9.990964));	// Jungfernstieg
		route.addWaypoint(new GeoPosition(53.552061, 9.994515));	// Ballindamm
		route.addWaypoint(new GeoPosition(53.557744, 10.004890));	// Alstertwiete
		route.addWaypoint(new GeoPosition(53.561154, 10.013484));	// Alster (Lohmühlenstraße)
		route.addWaypoint(new GeoPosition(53.556356, 10.021508));	// HAW
		return route;
	}

	public static GeoRoute createAlsterRoute2() {
		GeoRoute route = new GeoRoute("Außenalster");

		route.addWaypoint(new GeoPosition(53.556254, 10.021650));	// HAW
		route.addWaypoint(new GeoPosition(53.561192, 10.013245));	// Alster (Lohmühlenstraße)
		route.addWaypoint(new GeoPosition(53.564232, 10.016791));	// Schwanenwik
		route.addWaypoint(new GeoPosition(53.579689, 10.008131));	// Gellertstraße
		route.addWaypoint(new GeoPosition(53.579299, 9.998435));	// Eichenpark
		route.addWaypoint(new GeoPosition(53.567317, 10.001325));	// Alsterufer
		route.addWaypoint(new GeoPosition(53.558917, 9.995749));	// Kennedybrücke
		route.addWaypoint(new GeoPosition(53.557652, 10.005126));	// Alstertwiete
		route.addWaypoint(new GeoPosition(53.561183, 10.013398));	// Alster (Lohmühlenstraße)
		route.addWaypoint(new GeoPosition(53.556464, 10.021379));	// HAW		
		return route;
	}
	
	public static ArrayList<GeoRoute> createFlightRoutes() {
		GeoPosition hamburg = new GeoPosition(53.633060, 9.993501);		// Hamburg
		
		GeoRoute billund = new GeoRoute("Kiel -> Billund");
		billund.addWaypoint(hamburg);
		billund.addWaypoint(new GeoPosition(54.379486, 10.144082));		// Kiel
		billund.addWaypoint(new GeoPosition(55.740806, 9.152466));		// Billund

		GeoRoute london = new GeoRoute("London");
		london.addWaypoint(hamburg);
		london.addWaypoint(new GeoPosition(51.470754, -0.457657));		// London
		
		GeoRoute lyon = new GeoRoute("Amsterdam -> Lyon");
		lyon.addWaypoint(hamburg);
		lyon.addWaypoint(new GeoPosition(52.310480, 4.767684));			// Amsterdam
		lyon.addWaypoint(new GeoPosition(45.720407, 5.081052));			// Lyon
		
		GeoRoute rom = new GeoRoute("München -> Rom");
		rom.addWaypoint(hamburg);
		rom.addWaypoint(new GeoPosition(48.353634, 11.774738));			// München
		rom.addWaypoint(new GeoPosition(41.799804, 12.245763));			// Rom
		
		GeoRoute saltLake = new GeoRoute("Salt Lake City");
		saltLake.addWaypoint(hamburg);
		saltLake.addWaypoint(new GeoPosition(40.786723, -111.982586));	// Salt Lake City
		
		return new ArrayList<>(Arrays.asList(lyon, saltLake, rom, billund, london));
	}
}
