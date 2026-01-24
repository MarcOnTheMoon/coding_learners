package warehouse;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/** Unit tests for examination E-B3-OPP summer semester 2016.
 * 
 * @author Marc Hensel
 * @version 2016-06-16
 */
public class UnitTests {

	@Test
	public final void testPallet() {
		int trackingId = 20099;
		String destination = "Hamburg";
		Pallet pallet = new Pallet(trackingId, destination);
		
		// Constructor and getters
		assertNotNull(pallet);
		assertEquals(trackingId, pallet.getTrackingID());
		assertEquals(destination, pallet.getDestination());
		
		// toString()
		String expected = String.format("#%d to %s", trackingId, destination);
		assertEquals(expected, pallet.toString());
	}

	@Test
	public final void testCapacityException() {		
		// Constructor
		assertNotNull(new CapacityException());
		
		// Has correct super class?
		try {
			throw new CapacityException();
		} catch (RuntimeException e) {
		} catch (Throwable e) {
			fail("Incorrect super class for class CapacityException");
		}
	}
	
	@Test
	public final void testWarehouse() {
		int capacity = 3;
		Warehouse warehouse = new Warehouse(capacity);

		// Constructor and getter
		assertNotNull(warehouse);
		assertEquals(capacity, warehouse.getCapacity());
		
		// No pallet in warehouse
		Pallet[] pallets = warehouse.getInventory();
		assertNotNull(pallets);
		assertEquals(0, pallets.length);
		
		// Add pallets to warehouse
		Pallet pallet1 = new Pallet(789163, "Hamburg");
		Pallet pallet2 = new Pallet(625319, "London");
		Pallet pallet3 = new Pallet(537492, "Hamburg");
		Pallet pallet4 = new Pallet(853257, "London");
		
		warehouse.addPallet(pallet1);
		assertArrayEquals(new Pallet[]{pallet1}, warehouse.getInventory());

		warehouse.addPallet(pallet2);
		assertArrayEquals(new Pallet[]{pallet1, pallet2}, warehouse.getInventory());

		warehouse.addPallet(pallet3);
		assertArrayEquals(new Pallet[]{pallet1, pallet2, pallet3}, warehouse.getInventory());

		// Cannot add pallet when no more free capacity?
		warehouse.addPallet(pallet4);
		assertArrayEquals(new Pallet[]{pallet1, pallet2, pallet3}, warehouse.getInventory());
		
		// Get inventory for specific destination
		assertArrayEquals(new Pallet[]{pallet2}, warehouse.getInventory("London"));
		assertArrayEquals(new Pallet[]{pallet1, pallet3}, warehouse.getInventory("Hamburg"));
		assertArrayEquals(new Pallet[]{pallet1, pallet2, pallet3}, warehouse.getInventory());
		
		// Has pallet?		
		assertTrue(warehouse.hasPallet(pallet1));
		assertTrue(warehouse.hasPallet(pallet2));
		assertTrue(warehouse.hasPallet(pallet3));
		assertFalse(warehouse.hasPallet(pallet4));
		
		// toString() with pallets in warehouse
		String expected = String.format("%s\n%s\n%s\n", pallet1, pallet2, pallet3);
		assertEquals(expected, warehouse.toString());
	
		// Remove pallets
		warehouse.removePallet(pallet4);
		assertArrayEquals(new Pallet[]{pallet1, pallet2, pallet3}, warehouse.getInventory());

		warehouse.removePallet(pallet1);
		assertArrayEquals(new Pallet[]{pallet2, pallet3}, warehouse.getInventory());
		warehouse.removePallet(pallet1);
		assertArrayEquals(new Pallet[]{pallet2, pallet3}, warehouse.getInventory());

		warehouse.removePallet(pallet3);
		assertArrayEquals(new Pallet[]{pallet2}, warehouse.getInventory());

		warehouse.removePallet(pallet2);
		assertArrayEquals(new Pallet[0], warehouse.getInventory());

		warehouse.removePallet(pallet3);
		assertArrayEquals(new Pallet[0], warehouse.getInventory());
		
		// toString() for empty warehouse
		assertNotNull(warehouse.toString());
		assertEquals(0, warehouse.toString().length());
	}
}
