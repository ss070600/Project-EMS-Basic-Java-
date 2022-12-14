package daoImplementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daoInterfaces.BillDAOI;
import dbObjectClasses.Bill;

public class BillDAOImp extends AbstractConnectionEms implements BillDAOI {
	ArrayList<Bill> list = new ArrayList<Bill>();

	@Override
	public void refreshRecords() throws SQLException {
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from bill");

		int id, connectionId, consumerId, connectionTypeId, oldReading, newReading, billedUnits;
		double totalAmount;
		String dateTime;

		list.clear();

		while (rs.next()) {
			id = rs.getInt(1);
			connectionId = rs.getInt(2);
			consumerId = rs.getInt(3);
			connectionTypeId = rs.getInt(4);
			dateTime = rs.getString(5);
			oldReading = rs.getInt(6);
			newReading = rs.getInt(7);
			billedUnits = rs.getInt(8);
			totalAmount = rs.getDouble(9);
			list.add(new Bill(id, connectionId, consumerId, connectionTypeId, dateTime, oldReading, newReading,
					billedUnits, totalAmount));
		}
	}

	@Override
	public void getAll() throws SQLException {
		System.out.println("\nAll Generated Bill Details : \n");
		this.refreshRecords();

		for (Bill c : list) {
			System.out.println(c);
		}
	}

	@Override
	public Bill get(int inputId) throws SQLException {
		this.refreshRecords();
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from bill where id = " + inputId);

		int id, connectionId, consumerId, connectionTypeId, oldReading, newReading, billedUnits;
		double totalAmount;
		String dateTime;

		if (rs.next()) {
			id = rs.getInt(1);
			connectionId = rs.getInt(2);
			consumerId = rs.getInt(3);
			connectionTypeId = rs.getInt(4);
			dateTime = rs.getString(5);
			oldReading = rs.getInt(6);
			newReading = rs.getInt(7);
			billedUnits = rs.getInt(8);
			totalAmount = rs.getDouble(9);
			Bill b = new Bill(id, connectionId, consumerId, connectionTypeId, dateTime, oldReading, newReading,
					billedUnits, totalAmount);
			System.out.println(b);
			return b;
		} else {
			System.out.println("Input Id not exists");
			return null;
		}
	}
}
