package Test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.model.Contact;

class ContactTest {

	@Test
	void testContact() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		Contact contact = new Contact(id, firstName, lastName, phoneNumber, address);
		assertTrue(contact.getContactId().equals(id));
		assertTrue(contact.getFirstName().equals(firstName));
		assertTrue(contact.getLastName().equals(lastName));
		assertTrue(contact.getPhoneNumber().equals(phoneNumber));
		assertTrue(contact.getAddress().equals(address));
	}
	
	@Test
	void testId() {
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("012345678910",firstName, lastName, phoneNumber, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(null, firstName, lastName, phoneNumber, address);
		});
	}
	
	@Test
	void testFirstName() {
		String id = "01";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, "Extra Long name", lastName, phoneNumber, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, null, lastName, phoneNumber, address);
		});
	}
	
	@Test
	void testSetFirstName() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String longFirstName = "VeryLong first name";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		
		Contact contact = new Contact(id, "old name", lastName, phoneNumber, address);
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setFirstName(null);
		});
		//test if setLastName doesn't allow too long name
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setFirstName(longFirstName);
		});
		
		contact.setFirstName(firstName);
		assertEquals(firstName, contact.getFirstName());
		
	}
	
	@Test
	void testLastName() {
		String id = "01";
		String firstName = "Jim";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, firstName, "Extra Long last name", phoneNumber, address);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, firstName, null, phoneNumber, address);
		});
	}
	
	@Test
	void testSetLastName() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String longLastName = "VeryLong last name";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		
		Contact contact = new Contact(id, firstName, "old name", phoneNumber, address);
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setLastName(null);
		});
		//test if setLastName doesn't allow too long name
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setLastName(longLastName);
		});
		
		contact.setLastName(lastName);
		assertEquals(lastName, contact.getLastName());
		
	}
	
	@Test
	void testPhoneNumber() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String address = "123 Street RD";
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, firstName, lastName, "12345678", address);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, firstName, lastName, "12345678901", address);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(id, firstName, lastName, null, address);
		});
	}
	
	@Test
	void testSetPhoneNumber() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String shortNum = "12345678";
		String longNum = "12345678901";
		String address = "123 Street RD";
		
		Contact contact = new Contact(id, firstName, lastName, "0123456789", address);
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhoneNumber(null);
		});
		//test if setPhoneNumber doesn't allow too short or long number
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhoneNumber(shortNum);
		});
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhoneNumber(longNum);
		});
		
		contact.setPhoneNumber(phoneNumber);
		assertEquals(phoneNumber, contact.getPhoneNumber());
		
	}
	
	@Test
	void testLAddress() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, firstName, lastName, phoneNumber, "This address is so long, it is no longer a valid adress");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(id, firstName, lastName, phoneNumber, null);
		});
	}
	
	@Test
	void testSetAddress() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		String longAddress = "This address is so long, it is no longer a valid adress";
		
		Contact contact = new Contact(id, firstName, lastName, phoneNumber, "old address");
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setAddress(null);
		});
		//test if setAddress doesn't allow too long address
		assertThrows(IllegalArgumentException.class, ()-> {
			contact.setAddress(longAddress);
		});
		
		contact.setAddress(address);
		assertEquals(address, contact.getAddress());
		
	}

}
