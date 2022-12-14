package dbObjectClasses;

import ems.AbstractClassEms;
import ems.InterfaceEms;

public class ConnectionType extends AbstractClassEms implements InterfaceEms{
	private int id;
	private String type;
	private double fixedCharge;
	private double perUnitCharge;

	public ConnectionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConnectionType(int id, String type, double fixedCharge, double perUnitCharge) {
		super();
		this.id = id;
		this.type = type;
		this.fixedCharge = fixedCharge;
		this.perUnitCharge = perUnitCharge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getFixedCharge() {
		return fixedCharge;
	}

	public void setFixedCharge(double fixedCharge) {
		this.fixedCharge = fixedCharge;
	}

	public double getPerUnitCharge() {
		return perUnitCharge;
	}

	public void setPerUnitCharge(double perUnitCharge) {
		this.perUnitCharge = perUnitCharge;
	}

	@Override
	public String toString() {
		return "ConnectionType [id=" + id + ", type=" + type + ", fixedCharge=" + fixedCharge + ", perUnitCharge="
				+ perUnitCharge + "]";
	}

}
