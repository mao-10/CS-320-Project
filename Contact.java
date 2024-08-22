package main.java.model;
/**
 * 
 */

/**
 * @author maochristie_snhu
 *
 */
public class Contact {
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName,String phoneNumber, String address) {
		if(contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		else {
			this.firstName = firstName;
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		else {
			this.lastName = lastName;
		}
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		else {
			this.phoneNumber = phoneNumber;
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		else {
			this.address = address;
		}
	}
}
