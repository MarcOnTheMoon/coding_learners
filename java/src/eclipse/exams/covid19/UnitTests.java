package covid19;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

public class UnitTests {
	final private double DOUBLE_EPS_SCORE = 0.9;	// Precision in comparison of double numbers

	@Test
	public final void test_01_Getter() {
		int id = 2, x = 7, y = 20;
		MobileDevice device = new MobileDevice(id, x, y);

		// Do getters return the values passed to the constructor?
		assertEquals(id, device.getID());		
		assertEquals(x, device.getX());		
		assertEquals(y, device.getY());

		// Other variables initialized correctly?
		assertFalse(device.isPositive());
		assertNotNull(device.getContacts());
	}

	@Test
	public final void test_02_Setter() {
		int id = 2, x = 7, y = 20;
		MobileDevice device = new MobileDevice(id, 0, 0);

		// Do getters return values changed by setters?
		assertEquals(0, device.getX());		
		assertEquals(0, device.getY());
		device.setXY(x, y);
		assertEquals(x, device.getX());		
		assertEquals(y, device.getY());

		assertFalse(device.isPositive());
		device.setPositive(true);
		assertTrue(device.isPositive());
	}

	@Test
	public final void test_03_Contacts() throws Exception {
		int id = 2, x = 7, y = 20;
		MobileDevice device = new MobileDevice(id, x, y);
		MobileDevice contact1 = new MobileDevice(id, x, y);
		MobileDevice contact2 = new MobileDevice(id, x, y);
		MobileDevice noContact = new MobileDevice(id, x, y);

		// Access private method addContact()
		Method method = MobileDevice.class.getDeclaredMethod("addContact", MobileDevice.class);	
		method.setAccessible(true);

		// Initially empty list?
		assertEquals(0, device.getContacts().size());

		// Test addContact(): add two contacts by calling private method addContact() twice
		method.invoke(device, contact1);
		method.invoke(device, contact2);
		assertEquals(2, device.getContacts().size());

		// Test isContact()
		assertTrue(device.isContact(contact1));
		assertTrue(device.isContact(contact2));
		assertFalse(device.isContact(noContact));

		// Test addContact(): object not added, if already contained in list?
		method.invoke(device, contact2);
		assertEquals(2, device.getContacts().size());
		assertTrue(device.isContact(contact2));		
	}

	@Test
	public final void test_04_getDistance() throws Exception {
		int id = 2, x = 7, y = 20;
		MobileDevice device = new MobileDevice(id, x, y);

		// Access private method getDistance()
		Method method = MobileDevice.class.getDeclaredMethod("getDistance", MobileDevice.class);	
		method.setAccessible(true);

		// Locations differ in x-direction or y-direction, only
		int delta = 3;
		MobileDevice otherX = new MobileDevice(id, x + delta, y);
		MobileDevice otherY = new MobileDevice(id, x, y - delta);
		assertEquals(delta, (double)method.invoke(device, otherX), DOUBLE_EPS_SCORE);
		assertEquals(delta, (double)method.invoke(device, otherY), DOUBLE_EPS_SCORE);

		// Locations differ in x- and y-direction
		int dx = 3, dy = 4;
		double distance = Math.sqrt(dx * dx + dy * dy);
		MobileDevice otherXY = new MobileDevice(id, x - dx, y + dy);
		assertEquals(distance, (double)method.invoke(device, otherXY), DOUBLE_EPS_SCORE);
	}

	@Test
	public final void test_05_updateContacts() {
		int id = 2, x = 7, y = 20;
		int safetyDistance = 10;
		MobileDevice device = new MobileDevice(id, x, y);
		MobileDevice other1 = new MobileDevice(id, x + safetyDistance / 2, y);
		MobileDevice other2= new MobileDevice(id, x, y + (safetyDistance + 1));

		// Create list of other devices
		ArrayList<MobileDevice> others = new ArrayList<MobileDevice>(); 
		others.add(other1);
		others.add(other2);

		// Update contacts and check if correct device has been added to the list
		device.updateContacts(others, safetyDistance);
		assertTrue(device.getContacts().contains(other1));
		assertFalse(device.getContacts().contains(other2));

		// Check mutual contacts
		assertTrue(other1.getContacts().contains(device));
		assertFalse(other2.getContacts().contains(device));
	}

	@Test
	public final void test_06_compareTo() {
		int id = 2, x = 7, y = 20;
		MobileDevice device1 = new MobileDevice(id - 1, x, y);
		MobileDevice device2 = new MobileDevice(id, x, y);
		MobileDevice device3 = new MobileDevice(id + 1, x, y);

		// Does compareTo() return correct values?
		assertTrue(device2.compareTo(device1) > 0);
		assertTrue(device2.compareTo(device2) == 0);
		assertTrue(device2.compareTo(device3) < 0);
		assertTrue(device1.compareTo(device2) < 0);
		assertTrue(device3.compareTo(device2) > 0);		
	}

	@Test
	public final void test_07_toString() {
		int id = (int)(100.0 * Math.random());
		int x = 7, y = 20;
		MobileDevice device = new MobileDevice(id, x, y);

		// Without contacts: Does toString() return object's id?
		assertEquals(Integer.toString(id), device.toString());

		// With contacts
		String expected = String.format("%d < %d", id, id + 1);
		ArrayList<MobileDevice> contacts = device.getContacts();
		contacts.add(new MobileDevice(id + 1, x, y));
		assertEquals(expected, device.toString());
		
		contacts.add(new MobileDevice(id + 2, x, y));
		expected += ", " + (id + 2);
		assertEquals(expected, device.toString());

		contacts.add(new MobileDevice(id + 3, x, y));
		expected += ", " + (id + 3);
		assertEquals(expected, device.toString());
	}
}
