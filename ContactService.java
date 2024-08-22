package main.java.model;
/**
 * 
 */

/**
 * @author maochristie_snhu
 *
 */
import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	private List<Contact> contactList = new ArrayList<>();
	public List<Contact> getContactList(){
		return contactList;
	}
	
	public void newContact(String id, String firstName, String lastName, String phoneNumber, String address) {
		int i = 0;
		// check ID is unique
		while(i < contactList.size()) {
			if(id.equals(contactList.get(i).getContactId())) {
				throw new IllegalArgumentException("ID already exists");
			}
			i++;
		}
		Contact contact = new Contact(id, firstName, lastName, phoneNumber, address);
		contactList.add(contact);
	}
	// delete a contact by id
	public void deleteContact(String id) {
		int i = 0;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactId())) {
				contactList.remove(i);
			}
			i++;
		}
	}
	// update first name, last name, number, and address
	// id cannot be changes
	public void updateFirstName(String id, String firstName) {
		int i = 0;
		Contact contact;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactId())) {
				contact = contactList.get(i);
				contact.setFirstName(firstName);
			}
			i++;
		}
	}
	public void updateLastName(String id, String lastName) {
		int i = 0;
		Contact contact;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactId())) {
				contact = contactList.get(i);
				contact.setLastName(lastName);
			}
			i++;
		}
	}
	public void updatePhoneNumber(String id, String phoneNumber) {
		int i = 0;
		Contact contact;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactId())) {
				contact = contactList.get(i);
				contact.setPhoneNumber(phoneNumber);
			}
			i++;
		}
	}
	public void updateAddress(String id, String address) {
		int i = 0;
		Contact contact;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactId())) {
				contact = contactList.get(i);
				contact.setAddress(address);
			}
			i++;
		}
	}
	
}
