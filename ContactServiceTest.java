package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import main.java.model.ContactService;


class ContactServiceTest {

	@Test
	void testContactService() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		service.newContact(id, firstName, lastName, phoneNumber, address);
		assertTrue(service.getContactList().get(0).getContactId().equals(id));
		assertTrue(service.getContactList().get(0).getFirstName().equals(firstName));
		assertTrue(service.getContactList().get(0).getLastName().equals(lastName));
		assertTrue(service.getContactList().get(0).getPhoneNumber().equals(phoneNumber));
		assertTrue(service.getContactList().get(0).getAddress().equals(address));
	}
	
	@Test
	void testTaskServiceUpdate() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		service.newContact(id, "first name", "last Name", "1234567899", "123 Valley RD");
		service.updateFirstName(id, firstName);
		service.updateLastName(id, lastName);
		service.updatePhoneNumber(id, phoneNumber);
		service.updateAddress(id, address);
		assertEquals(service.getContactList().get(0).getFirstName(), firstName);
		assertEquals(service.getContactList().get(0).getLastName(), lastName);
		assertEquals(service.getContactList().get(0).getPhoneNumber(), phoneNumber);
		assertEquals(service.getContactList().get(0).getAddress(), address);
	}
	
	@Test
	void testNullContact() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		// null id
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(null, firstName, lastName, phoneNumber, address);
		});
		// null first name
		assertThrows(IllegalArgumentException.class, ()-> {
			service.newContact(id, null, lastName, phoneNumber, address);
		});
		// null last name
		assertThrows(IllegalArgumentException.class, ()-> {
			service.newContact(id, firstName, null, phoneNumber, address);
		});
		// null phone num
		assertThrows(IllegalArgumentException.class, ()-> {
			service.newContact(id, firstName, lastName, null, address);
		});
		// null address
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(id, firstName, lastName, phoneNumber, null);
		});
	}
	
	@Test
	void testLongFirstName() {
		String id = "01";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(id,"Extra long name", lastName, phoneNumber, address);
		});
	}
	@Test
	void testLongLastName() {
		String id = "01";
		String firstName = "Jim";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(id, firstName, "Extra long last name", phoneNumber, address);
		});
	}
	
	@Test
	void testUpdatePhoneNumber() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(id, firstName, lastName, "012345678901", address);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(id, firstName, lastName, "12345", address);
		});
	}
	
	@Test
	void testLongAddress() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact(id, firstName, lastName, phoneNumber, "This address is extra long, which makes it an invalid address");
		});
	}
	
	@Test
	void testDeleteContact() {
		String id = "01";
		String firstName = "Jim";
		String lastName = "Brown";
		String phoneNumber = "1234567890";
		String address = "123 Street RD";
		ContactService service = new ContactService();
		service.newContact(id, firstName, lastName, phoneNumber, address);
		assertEquals(service.getContactList().size(), 1);
		service.deleteContact(id);
		assertEquals(service.getContactList().size(), 0);
	}
	
	@Test
	void testContactServiceUniqueID() {
		ContactService service = new ContactService();
		service.newContact("01", "Jim", "Brown", "1234567890", "123 Valley RD");
		service.newContact("02", "Greg", "Brown", "1234567899", "123 Street RD");
		assertThrows(IllegalArgumentException.class, ()->{
			service.newContact("01", "Bob", "Brown", "1234567888", "address");
		});
	}

}
