package daoImplementations;

import java.util.ArrayList;
import daoInterfaces.ConsumerDAOI;
import dbObjectClasses.Consumer;
import java.sql.*;

public class ConsumerDAOImp extends AbstractConnectionEms implements ConsumerDAOI {
	ArrayList<Consumer> list = new ArrayList<Consumer>();

	@Override
	public void refreshRecords() throws SQLException {
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from consumer");

		int id, addressId;
		String firstName, lastName, addedOn;

		list.clear();

		while (rs.next()) {
			id = rs.getInt(1);
			firstName = rs.getString(2);
			lastName = rs.getString(3);
			addressId = rs.getInt(4);
			addedOn = rs.getString(5);
			list.add(new Consumer(id, firstName, lastName, addressId, addedOn));
		}
	}

	@Override
	public void getAll() throws SQLException {
		System.out.println("\nAll Consumer Details : \n");
		this.refreshRecords();

		for (Consumer c : list) {
			System.out.println(c);
		}
	}

	@Override
	public Consumer get(int inputId) throws SQLException {
		this.refreshRecords();
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from consumer where id = " + inputId);

		int id, addressId;
		String firstName, lastName, addedOn;

		if (rs.next()) {
			id = rs.getInt(1);
			firstName = rs.getString(2);
			lastName = rs.getString(3);
			addressId = rs.getInt(4);
			addedOn = rs.getString(5);
			Consumer c = new Consumer(id, firstName, lastName, addressId, addedOn);
			System.out.println(c);
			return c;
		} else {
			System.out.println("Input Id not exists");
			return null;
		}
	}

//	@Override
//	public void delete(int inputId) throws SQLException {
//		this.refreshRecords();
//		Statement st = AbstractConnectionEms.con.createStatement();
//		int rowCount = st.executeUpdate("delete from consumer where id = " + inputId);
//
//		if (rowCount > 0) {
//			if (rowCount == 1)
//				System.out.println("Record deleted");
//			else
//				System.out.println("Records deleted");
//		} else {
//			System.out.println("Input Id not exists");
//		}
//
//	}

}
