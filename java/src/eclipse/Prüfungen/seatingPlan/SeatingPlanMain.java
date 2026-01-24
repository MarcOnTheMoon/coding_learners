package seatingPlan;

/** Application demonstrating a seating plan for an aircraft.
 * 
 * Sample solution E-B3-OPP, lab exam WiSe 2016/17.
 * 
 * @author Marc Hensel
 */
public class SeatingPlanMain {

	public static void main(String[] args) {
		SeatingPlan seatingPlan;
		
		// Create seating plan
		System.out.println("Creating seating plan ...");
		seatingPlan = new SeatingPlan("Bombardier CRJ-200", 50, 4);

		// Reserve some seats
		System.out.println("Reserving seats 6C, 6D, 14A, and 14B ...");
		seatingPlan.reserveSeat("6C");
		seatingPlan.reserveSeat("6D");
		seatingPlan.reserveSeat("14A");
		seatingPlan.reserveSeat("14B");
		
		// Print seating plan and number of vacant/reserved seats to the console
		System.out.println("Displaying seating plan and seat count ...\n");
		System.out.println(seatingPlan);
		System.out.println(
				String.format("%d vacant, %d reserved*",
				seatingPlan.getNumberSeatsVacant(),
				seatingPlan.getNumberSeatsReserved()));		
	}
}
