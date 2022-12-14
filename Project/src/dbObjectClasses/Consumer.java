package dbObjectClasses;

import ems.AbstractClassEms;
import ems.InterfaceEms;

public class Consumer extends AbstractClassEms implements InterfaceEms{
	private int id;
	private String firstName;
	private String lastName;
	private int addressId;
	private String addedOn;

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumer(int id, String firstName, String lastName, int addressId, String addedOn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.addedOn = addedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "Consumer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addressId=" + addressId
				+ ", addedOn=" + addedOn + "]";
	}

}
