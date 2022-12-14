package daoImplementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daoInterfaces.AddressDAOI;
import dbObjectClasses.Address;

public class AddressDAOImp extends AbstractConnectionEms implements AddressDAOI {
	ArrayList<Address> list = new ArrayList<Address>();

	@Override
	public void refreshRecords() throws SQLException {
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from address");

		int id;
		String area, city;

		list.clear();

		while (rs.next()) {
			id = rs.getInt(1);
			area = rs.getString(2);
			city = rs.getString(3);
			list.add(new Address(id, area, city));
		}
	}

	@Override
	public void getAll() throws SQLException {
		System.out.println("\nAll Available Addresses Details : \n");
		this.refreshRecords();

		for (Address c : list) {
			System.out.println(c);
		}
	}

	@Override
	public Address get(int inputId) throws SQLException {
		this.refreshRecords();
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from address where id = " + inputId);

		int id;
		String area, city;

		if (rs.next()) {
			id = rs.getInt(1);
			area = rs.getString(2);
			city = rs.getString(3);
			Address a = new Address(id, area, city);
			System.out.println(a);
			return a;
		} else {
			System.out.println("Input Id not exists");
			return null;
		}
	}
}
