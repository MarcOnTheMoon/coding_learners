package seating_plan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UnitTests {

	@Test
	public final void test_AircraftSeat_ConstructorGetters() {
		int rowNumber = 6;
		char position = 'D';
		AircraftSeat seat = new AircraftSeat(rowNumber, position);
		
		// Parameters assigned to instance variables and getters implemented
		assertEquals(rowNumber, seat.getRowNumber());
		assertEquals(position, seat.getPosition());
	}

	@Test
	public final void test_AircraftSeat_Reservable() {
		int rowNumber = 6;
		char position = 'D';
		AircraftSeat seat = new AircraftSeat(rowNumber, position);

		// Initially seat is not reserved
		assertEquals(false, seat.isReserved());
		
		// Modify reservation: true/false
		seat.reserve(true);
		assertEquals(true, seat.isReserved());
		seat.reserve(false);
		assertEquals(false, seat.isReserved());
	}

	@Test
	public final void test_AircraftSeat_toString() {
		// 1-digit and 2-digit rows
		AircraftSeat seat6A = new AircraftSeat(6, 'A');
		AircraftSeat seat12C = new AircraftSeat(12, 'C');

		assertEquals("6A", seat6A.toString());
		assertEquals("12C", seat12C.toString());
		
		// Does not change when seat is reserved
		seat12C.reserve(true);
		assertEquals("12C", seat12C.toString());
		seat12C.reserve(false);
		assertEquals("12C", seat12C.toString());
	}

	@Test
	public final void test_SeatingPlan_ConstructorGetters() {
		String aircraftName = "Aircraft-OPP";
		int numberSeats = 12, seatsPerRow = 4; 
		SeatingPlan seatingPlan = new SeatingPlan(aircraftName, numberSeats, seatsPerRow);
	
		// Parameters assigned to instance variables and getters implemented
		assertEquals(aircraftName, seatingPlan.getAircraftName());		
		assertEquals(numberSeats, seatingPlan.getNumberSeats());		
		assertEquals(seatsPerRow, seatingPlan.getSeatsPerRow());		
	}

	@Test
	public final void test_SeatingPlan_ConstructorList() {
		int numberSeats = 8;
		int seatsPerRow = 4;
		SeatingPlan seatingPlan = new SeatingPlan("Aircraft-OPP", numberSeats, seatsPerRow);	
		int expectedRow[] = { 1, 1, 1, 1, 2, 2, 2, 2 };
		char expectedPosition[] = { 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D' };

		// Correct seat names for 4 seats per row?
		for (int i = 0; i < numberSeats; i++) {
			AircraftSeat seat = seatingPlan.getSeat(i);
			assertEquals(expectedRow[i], seat.getRowNumber());
			assertEquals(expectedPosition[i], seat.getPosition());
		}
	}

	@Test
	public final void test_SeatingPlan_getNumberSeatsReservedVacant() {
		int numberSeats = 8;
		int seatsPerRow = 4;
		SeatingPlan seatingPlan = new SeatingPlan("Aircraft-OPP", numberSeats, seatsPerRow);	

		// Initially no seat reserved
		assertEquals(0, seatingPlan.getNumberSeatsReserved());
		assertEquals(numberSeats, seatingPlan.getNumberSeatsVacant());

		// Reserve all seats
		for (int i = 0; i < numberSeats; i++) {
			seatingPlan.getSeat(i).reserve(true);
			assertEquals(i + 1, seatingPlan.getNumberSeatsReserved());
			assertEquals(numberSeats - (i + 1), seatingPlan.getNumberSeatsVacant());
		}
	}

	@Test
	public final void test_SeatingPlan_reserveSeatException() throws Exception {
		int numberSeats = 6, seatsPerRow = 4;
		SeatingPlan seatingPlan = new SeatingPlan("Aircraft-OPP", numberSeats, seatsPerRow);

		// Throw assert on invalid row and return correct message?
		try {
			seatingPlan.reserveSeat("7A");
		} catch (InvalidSeatException e) {
			assertEquals("7A", e.getMessage());
			return;
		}
		fail();
	}

	@Test
	public final void test_SeatingPlan_toString() {
		SeatingPlan seatingPlan;
		String expected;
		
		// Aircraft without seats: "Seating plan <AircraftName>:\n"
		seatingPlan = new SeatingPlan("aircraft-OPP", 0, 0);
		expected = "Seating plan aircraft-OPP:\n";
		assertEquals(expected, seatingPlan.toString());

		// Add 1 row with 4 seats:
		// - For each seat call seat.toString()
		// - Format this "%3s " (if seat not reserved) or "%3s*" (if seat is reserved)
		// - Add "\n" if seat position is 'D', else add a space " "
		seatingPlan = new SeatingPlan("aircraft-OPP", 4, 4);
		expected = "Seating plan aircraft-OPP:\n 1A   1B   1C   1D \n";
		assertEquals(expected, seatingPlan.toString());

		// 2 rows with 4 seats each
		seatingPlan = new SeatingPlan("aircraft-OPP", 8, 4);
		expected = "Seating plan aircraft-OPP:\n 1A   1B   1C   1D \n 2A   2B   2C   2D \n";
		assertEquals(expected, seatingPlan.toString());

		// All seats reserved		
		for (int i = 0; i < seatingPlan.getNumberSeats(); i++)
			seatingPlan.getSeat(i).reserve(true);
		
		expected = "Seating plan aircraft-OPP:\n 1A*  1B*  1C*  1D*\n 2A*  2B*  2C*  2D*\n";
		assertEquals(expected, seatingPlan.toString());
	}

	@Test
	public final void test_InvalidSeatException_Message() {
		String message = "6E";
		InvalidSeatException exception = new InvalidSeatException(message);		

		// Exception object returns correct message
		assertEquals(message, exception.getMessage());
	}
}

