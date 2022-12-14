package dbObjectClasses;

import ems.AbstractClassEms;
import ems.InterfaceEms;

public class Connections extends AbstractClassEms implements InterfaceEms {
	private int id;
	private int consumerId;
	private int connectionTypeId;
	private int oldReading;
	private String addedOn;

	public Connections() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connections(int id, int consumerId, int connectionTypeId, int oldReading, String addedOn) {
		super();
		this.id = id;
		this.consumerId = consumerId;
		this.connectionTypeId = connectionTypeId;
		this.oldReading = oldReading;
		this.addedOn = addedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getConnectionTypeId() {
		return connectionTypeId;
	}

	public void setConnectionTypeId(int connectionTypeId) {
		this.connectionTypeId = connectionTypeId;
	}

	public int getOldReading() {
		return oldReading;
	}

	public void setOldReading(int oldReading) {
		this.oldReading = oldReading;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "Connections [id=" + id + ", consumerId=" + consumerId + ", connectionTypeId=" + connectionTypeId
				+ ", oldReading=" + oldReading + ", addedOn=" + addedOn + "]";
	}

	@Override
	public void classInfo() {
		System.out.println(
				"this class is created to store various details available in each record of connections table in its object like id, consumer id , date added on etc..");
	}

}
