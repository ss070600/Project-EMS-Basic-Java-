package daoImplementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daoInterfaces.ConnectionTypeDAOI;
import dbObjectClasses.ConnectionType;

public class ConnectionTypeDAOImp extends AbstractConnectionEms implements ConnectionTypeDAOI {
	ArrayList<ConnectionType> list = new ArrayList<ConnectionType>();

	@Override
	public void refreshRecords() throws SQLException {
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from connection_type");

		int id;
		double fixedCharge, perUnitCharge;
		String type;

		list.clear();

		while (rs.next()) {
			id = rs.getInt(1);
			type = rs.getString(2);
			fixedCharge = rs.getDouble(3);
			perUnitCharge = rs.getDouble(4);
			list.add(new ConnectionType(id, type, fixedCharge, perUnitCharge));
		}
	}

	@Override
	public void getAll() throws SQLException {
		System.out.println("\nAll Connection Type Details : \n");
		this.refreshRecords();

		for (ConnectionType c : list) {
			System.out.println(c);
		}
	}

	@Override
	public ConnectionType get(int inputId) throws SQLException {
		this.refreshRecords();
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from connection_type where id = " + inputId);

		int id;
		double fixedCharge, perUnitCharge;
		String type;

		if (rs.next()) {
			id = rs.getInt(1);
			type = rs.getString(2);
			fixedCharge = rs.getDouble(3);
			perUnitCharge = rs.getDouble(4);
			ConnectionType c = new ConnectionType(id, type, fixedCharge, perUnitCharge);
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
//		int rowCount = st.executeUpdate("delete from connection_type where id = " + inputId);
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
