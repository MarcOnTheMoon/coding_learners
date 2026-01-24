package familyTree;

import static org.junit.Assert.*;
import org.junit.Test;

public class FamilyTreeTest {

	@Test
	public final void testR03Person_Getters() {
		Person person = new Person("Marc", "Hensel");
		assertEquals("Marc", person.getFirstName());
		assertEquals("Hensel", person.getSurname());
	}

	@Test
	public final void testR04Person_equals() {
		Person person = new Person("Horst", "Kaluppke");
		Person sameRef = person;
		Person sameData = new Person("Horst", "Kaluppke");
		Person otherFirstName = new Person("Heinz", "Kaluppke");
		Person otherSurname = new Person("Horst", "Meier");
		
		assertTrue("Same reference variable", person.equals(person));
		assertTrue("Same reference", person.equals(sameRef));
		assertTrue("Same data", person.equals(sameData));
		assertFalse("Other first name", person.equals(otherFirstName));
		assertFalse("Other surname", person.equals(otherSurname));
		assertFalse("Null", person.equals(null));
		assertFalse("Other class", person.equals("This is not a Person object"));
	}

	@Test
	public final void testR08FamilyMember_GettersSetters() {
		FamilyMember member = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember mother = new FamilyMember("Marge", "Bouvier", 1958, false);
		FamilyMember father = new FamilyMember("Homer", "Simpson", 1956, true);

		// Simple getter
		assertEquals(1982, member.getBirthYear());

		// Add parents ...
		member.setMother(mother);
		member.setFather(father);

		// ... and assert they are added to the child
		assertEquals(mother, member.getMother());
		assertEquals(father, member.getFather());
		
		// ... and assert the child is added to the parents
		assertEquals(1, mother.getChildren().length);
		assertEquals(member, mother.getChildren()[0]);

		assertEquals(1, father.getChildren().length);
		assertEquals(member, father.getChildren()[0]);
	}

	@Test
	public final void testR09FamilyMember_getChildren() {
		FamilyMember member = new FamilyMember("Homer", "Simpson", 1956, true);
		FamilyMember son = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember daughter = new FamilyMember("Lisa", "Simpson", 1984, false);

		member.addChild(son);
		member.addChild(daughter);

		FamilyMember[] childrenArray = member.getChildren();
		assertEquals(2, childrenArray.length);
		assertEquals(son, childrenArray[0]);
		assertEquals(daughter, childrenArray[1]);
	}

	@Test
	public final void testR11FamilyMember_addChild() {
		FamilyMember member = new FamilyMember("Homer", "Simpson", 1956, true);
		FamilyMember son = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember daughter = new FamilyMember("Lisa", "Simpson", 1984, false);

		// Are children added to father's children list?
		member.addChild(son);
		member.addChild(daughter);
		FamilyMember[] children = member.getChildren();
		assertEquals(2, children.length);
		assertEquals(son, children[0]);
		assertEquals(daughter, children[1]);
		
		// No duplicates?
		member.addChild(daughter);
		member.addChild(son);
		children = member.getChildren();
		assertEquals(2, children.length);
		assertEquals(son, children[0]);
		assertEquals(daughter, children[1]);
	}

	@Test
	public final void testR11FamilyMember_addChild_setParent() {
		FamilyMember mother = new FamilyMember("Marge", "Bouvier", 1958, false);
		FamilyMember father = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember son = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember daughter = new FamilyMember("Lisa", "Simpson", 1984, false);

		mother.addChild(son);
		mother.addChild(daughter);
		assertEquals(mother, son.getMother());
		assertEquals(mother, daughter.getMother());

		father.addChild(son);
		father.addChild(daughter);
		assertEquals(father, son.getFather());
		assertEquals(father, daughter.getFather());
	}

	@Test
	public final void testR12FamilyMember_toString() {
        // Test case: are references to parents set?
		FamilyMember mother = new FamilyMember("Marge", "Bouvier", 1958, false);
		FamilyMember son = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember daughter = new FamilyMember("Lisa", "Simpson", 1984, false);

		String expected = "Bouvier, Marge (*1958)";
		assertEquals(expected, mother.toString());

		mother.addChild(son);
		expected += "\n  -> Bart Simpson";
		assertEquals(expected, mother.toString());

		mother.addChild(daughter);
		expected += ", Lisa Simpson";
		assertEquals(expected, mother.toString());
	}
	
	@Test
	public final void testR13FamilyMember_equals() {
		FamilyMember member = new FamilyMember("Lisa", "Simpson", 1984, false);
		FamilyMember sameRef = member;
		FamilyMember sameData = new FamilyMember("Lisa", "Simpson", 1984, false);
		FamilyMember otherFirstName = new FamilyMember("Jessica", "Simpson", 1984, false);
		FamilyMember otherSurname = new FamilyMember("Lisa", "Minelli", 1984, false);
		FamilyMember otherBirthYear = new FamilyMember("Lisa", "Simpson", 1981, false);
		FamilyMember otherSex = new FamilyMember("Lisa", "Simpson", 1984, true);
		
		assertTrue("Same reference variable", member.equals(member));
		assertTrue("Same reference", member.equals(sameRef));
		assertTrue("Same data", member.equals(sameData));

		assertFalse("Other first name", member.equals(otherFirstName));
		assertFalse("Other surname", member.equals(otherSurname));
		assertFalse("Other birth year", member.equals(otherBirthYear));
		assertFalse("Other sex", member.equals(otherSex));
		assertFalse("Null", member.equals(null));
		assertFalse("Other class", member.equals("This is not a Person object"));
	}
	
	@Test
	public final void testR14FamilyMember_compareTo() {
		FamilyMember member = new FamilyMember("Lisa", "Simpson", 1984, false);
		FamilyMember sameRef = member;
		FamilyMember sameData = new FamilyMember("Lisa", "Simpson", 1984, false);
		FamilyMember smallerSurname = new FamilyMember("Lisa", "Sampson", 1984, false);
		FamilyMember biggerSurname = new FamilyMember("Lisa", "Sumpson", 1984, false);
		FamilyMember smallerFirstName = new FamilyMember("Lasa", "Simpson", 1984, false);
		FamilyMember biggerFirstName = new FamilyMember("Lusa", "Simpson", 1984, false);
		FamilyMember smallerYear = new FamilyMember("Lisa", "Simpson", 1983, false);
		FamilyMember biggerYear = new FamilyMember("Lisa", "Simpson", 1985, false);

		assertTrue("Same reference variable", member.compareTo(member) == 0);
		assertTrue("Same reference", member.compareTo(sameRef) == 0);
		assertTrue("Same data", member.compareTo(sameData) == 0);

		assertTrue("Smaller surname", member.compareTo(smallerSurname) > 0);
		assertTrue("Bigger surname", member.compareTo(biggerSurname) < 0);
		assertTrue("Smaller first name", member.compareTo(smallerFirstName) > 0);
		assertTrue("Bigger first name", member.compareTo(biggerFirstName) < 0);
		assertTrue("Smaller year", member.compareTo(smallerYear) > 0);
		assertTrue("Bigger year", member.compareTo(biggerYear) < 0);
	}

	@Test
	public final void testR17FamilyTree_createPerson() {
		FamilyTree tree = new FamilyTree();
		FamilyMember bart = tree.createPerson("Bart", "Simpson", 1982, true);
		
        assertEquals("Bart", bart.getFirstName());
		assertEquals("Simpson", bart.getSurname());
		assertEquals(1982, bart.getBirthYear());
		assertEquals(null, bart.getMother());
		assertEquals(null, bart.getFather());
		assertEquals(0, bart.getChildren().length);
	}

	@SuppressWarnings("unused")
	@Test
	public final void testR18FamilyTree_findPerson() {
		FamilyTree tree = new FamilyTree();

		FamilyMember bart = tree.createPerson("Bart", "Simpson", 1982, true);
		assertEquals(bart, tree.findPerson("Bart", "Simpson", 1982));
		assertEquals(null, tree.findPerson("Lisa", "Simpson", 1984));
		
		FamilyMember lisa = tree.createPerson("Lisa", "Simpson", 1984, false);	
		FamilyMember bart2 = tree.createPerson("Bart", "Simpson", 1982, true);
		assertEquals(bart, tree.findPerson("Bart", "Simpson", 1982));
		assertEquals(lisa, tree.findPerson("Lisa", "Simpson", 1984));
	}

	@Test
	public final void testR19FamilyTree_toString() {
		FamilyTree tree = new FamilyTree();
		
		// Empty tree
		String output = "Family Tree:\n------------\n";
		assertEquals(output, tree.toString());

		// Sorted members (without parents & children)
		FamilyMember lisa = tree.createPerson("Lisa", "Simpson", 1984, false);	
		FamilyMember bart = tree.createPerson("Bart", "Simpson", 1982, true);
		
		output = String.format("Family Tree:\n------------\n%s\n%s\n", bart, lisa);
		assertEquals(output, tree.toString());

		// Sorted members (with parents & children)
		FamilyMember marge = tree.createPerson("Marge", "Bouvier", 1958, false);
		bart.setMother(marge);
		lisa.setMother(marge);
		
		output = String.format("Family Tree:\n------------\n%s\n%s\n%s\n", marge, bart, lisa);
		assertEquals(output, tree.toString());
	}
	
	@Test
	public final void testR22MismatchException_getMessage() {
		MismatchException e = new MismatchException("This is the message.");
		assertEquals("This is the message.", e.getMessage());
	}
	
	@Test
	public final void testR23MismatchException_Thrown() {
		FamilyMember daughter = new FamilyMember("Lisa", "Simpson", 1984, false);	
		FamilyMember mother = new FamilyMember("Marge", "Bouvier", 1958, false);
		FamilyMember father = new FamilyMember("Homer", "Simpson", 1956, true);
		
		// Set mother
		try {
			daughter.setMother(father);
		} catch (MismatchException e) {
			assertEquals("Mother cannot be male: " + father, e.getMessage());
		} catch (Exception e) {
		}
		
		// Set father
		try {
			daughter.setFather(mother);
		} catch (MismatchException e) {
			assertEquals("Father cannot be female: " + mother, e.getMessage());
		} catch (Exception e) {
		}
	}
}

