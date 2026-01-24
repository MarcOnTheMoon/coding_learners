package flightZones;

public class FlightDemo {

	private static void addZones(ZoneMap map) {
		map.addZone(new Zone("Uni-Klinik Eppendorf", 53.591176, 9.975552));
		map.addZone(new Zone("Klinik St. Georg", 53.558954, 10.020080));
		map.addZone(new Zone("Polizei Steindamm", 53.554947, 10.016630));
		map.addZone(new Zone("Marienkrankenhaus", 53.558991, 10.030476));
		map.addZone(new Zone("Polizei Horn", 53.553908, 10.085250));
	}
	
	public static void main(String[] args) {
		// Create zone map
		ZoneMap map = new ZoneMap();
		addZones(map);
		System.out.println(map);

		// Location: HAW Hamburg
		Quadcopter copter = new Quadcopter("SuperBee", 53.557106, 10.023304);
		Zone zone = map.nearestZone(copter);
		double distance = Location.distanceMeter(copter, zone);
		System.out.printf("HAW Hamburg     : Nearest zone is %s (distance: %.1f km)\n", zone, distance/1000.0);
		
		// Location: Horner Rennbahn
		copter.setLocation(53.557813, 10.085848);
		zone = map.nearestZone(copter);
		distance = Location.distanceMeter(copter, zone);
		System.out.printf("Horner Rennbahn : Nearest zone is %s (distance: %.1f km)\n", zone, distance/1000.0);
		
		// Location: Stadtpark
		copter.setLocation(53.594338, 10.021080);
		zone = map.nearestZone(copter);
		distance = Location.distanceMeter(copter, zone);
		System.out.printf("Stadtpark       : Nearest zone is %s (distance: %.1f km)\n", zone, distance/1000.0);		
	}
}
