package daoImplementations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import daoInterfaces.ConnectionsDAOI;
import dbObjectClasses.Connections;

public class ConnectionsDAOImp extends AbstractConnectionEms implements ConnectionsDAOI {
	ArrayList<Connections> list = new ArrayList<Connections>();

	public ArrayList<Connections> getList() {
		return list;
	}

	@Override
	public void refreshRecords() throws SQLException {
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from connections order by id");

		int id, consumerId, connectionTypeId, oldReading;
		String addedOn;

		list.clear();

		while (rs.next()) {
			id = rs.getInt(1);
			consumerId = rs.getInt(2);
			connectionTypeId = rs.getInt(3);
			oldReading = rs.getInt(4);
			addedOn = rs.getString(5);
			list.add(new Connections(id, consumerId, connectionTypeId, oldReading, addedOn));
		}
	}

	@Override
	public void getAll() throws SQLException {
		System.out.println("\nAll Available Connection Details : \n");
		this.refreshRecords();

		for (Connections c : list) {
			System.out.println(c);
		}
	}

	@Override
	public Connections get(int inputId) throws SQLException {
		this.refreshRecords();
		Statement st = AbstractConnectionEms.con.createStatement();
		ResultSet rs = st.executeQuery("select * from connections where id = " + inputId);

		int id, consumerId, connectionTypeId, oldReading;
		String addedOn;

		if (rs.next()) {
			id = rs.getInt(1);
			consumerId = rs.getInt(2);
			connectionTypeId = rs.getInt(3);
			oldReading = rs.getInt(4);
			addedOn = rs.getString(5);
			Connections c = new Connections(id, consumerId, connectionTypeId, oldReading, addedOn);
			System.out.println(c);
			return c;
		} else {
			System.out.println("Input Id not exists");
			return null;
		}
	}

	@Override
	public void add(Scanner sc) throws SQLException {

		String area, city, firstName, lastName;
		String addressId, consumerId, connectionTypeId;

		// String addressInsert = "";

		System.out.println("Please read and carefully enter the details\n");
		new AddressDAOImp().getAll();
		System.out.println(
				"\nif your address id is available above then enter address id else press 'Y' to add your address\n");
		addressId = sc.nextLine();

		// if address_id not exists
		if (addressId.equals("y") || addressId.equals("Y")) {
			System.out.println("\nenter your area name : ");
			area = sc.nextLine();
			System.out.println("\nenter your city name");
			city = sc.nextLine();

			new ConsumerDAOImp().getAll();
			System.out.println("\nif you are an existing customer pick enter your id else press 'Y'");
			consumerId = sc.nextLine();

			// if consumer_id not exists
			if (consumerId.equals("y") || consumerId.equals("Y")) {
				System.out.println("\nenter your first name : ");
				firstName = sc.nextLine();
				System.out.println("\nenter your last name : ");
				lastName = sc.nextLine();

				new ConnectionTypeDAOImp().getAll();
				System.out.println("\nPick the connection type id from above data and enter : ");
				connectionTypeId = sc.nextLine();

				// Mysql insertion below
				CallableStatement callable = con.prepareCall("{call registerAddress(?,?,?)}");
				callable.setString(1, area);
				callable.setString(2, city);
				callable.registerOutParameter(3, java.sql.Types.INTEGER);
				callable.executeUpdate();

				int address_id = callable.getInt(3);

				callable = con.prepareCall("{call registerConsumer(?,?,?,?)}");
				callable.setString(1, firstName);
				callable.setString(2, lastName);
				callable.setInt(3, address_id);
				callable.registerOutParameter(4, java.sql.Types.INTEGER);
				callable.executeUpdate();
				int consumer_id = callable.getInt(4);

				callable = con.prepareCall("{call registerConnection(?,?,?,?)}");
				callable.setInt(1, consumer_id);
				callable.setInt(2, Integer.parseInt(connectionTypeId));
				callable.setInt(3, 0);
				callable.registerOutParameter(4, java.sql.Types.INTEGER);
				callable.executeUpdate();
				int connection_id = callable.getInt(4);
				System.out.println("-------------------------------------------");
				System.out.println("Your New Connection id is : " + connection_id);
				System.out.println("-------------------------------------------");

			} else { // if consumer_id exists
				new ConnectionTypeDAOImp().getAll();
				System.out.println("\nPick the connection type id from above data and enter : ");
				connectionTypeId = sc.nextLine();

				CallableStatement callable = con.prepareCall("{call registerConnection(?,?,?,?)}");
				callable.setInt(1, Integer.parseInt(consumerId));
				callable.setInt(2, Integer.parseInt(connectionTypeId));
				callable.setInt(3, 0);
				callable.registerOutParameter(4, java.sql.Types.INTEGER);
				callable.executeUpdate();
				int connection_id = callable.getInt(4);
				System.out.println("-------------------------------------------");
				System.out.println("Your New Connection id is : " + connection_id);
				System.out.println("-------------------------------------------");
			}
		} else {// if address_id exists
			new ConsumerDAOImp().getAll();
			System.out.println("\nif you are an existing customer pick enter your id else press 'Y'");
			consumerId = sc.nextLine();

			// if address_id exists and consumer_id not exists
			if (consumerId.equals("y") || consumerId.equals("Y")) {
				System.out.println("\nenter your first name : ");
				firstName = sc.nextLine();
				System.out.println("\nenter your last name : ");
				lastName = sc.nextLine();

				new ConnectionTypeDAOImp().getAll();
				System.out.println("\nPick the connection type id from above data and enter : ");
				connectionTypeId = sc.nextLine();

				// Mysql insertion below
				CallableStatement callable = con.prepareCall("{call registerConsumer(?,?,?,?)}");
				callable.setString(1, firstName);
				callable.setString(2, lastName);
				callable.setInt(3, Integer.parseInt(addressId));
				callable.registerOutParameter(4, java.sql.Types.INTEGER);
				callable.executeUpdate();

				int consumer_id = callable.getInt(4);

				callable = con.prepareCall("{call registerConnection(?,?,?,?)}");
				callable.setInt(1, consumer_id);
				callable.setInt(2, Integer.parseInt(connectionTypeId));
				callable.setInt(3, 0);
				callable.registerOutParameter(4, java.sql.Types.INTEGER);
				callable.executeUpdate();
				int connection_id = callable.getInt(4);
				System.out.println("-------------------------------------------");
				System.out.println("Your New Connection id is : " + connection_id);
				System.out.println("-------------------------------------------");

			} else {// if address_id exists and consumer_id exists
				new ConnectionTypeDAOImp().getAll();
				System.out.println("\nPick the connection type id from above data and enter : ");
				connectionTypeId = sc.nextLine();

				CallableStatement callable = con.prepareCall("{call registerConnection(?,?,?,?)}");
				callable.setInt(1, Integer.parseInt(consumerId));
				callable.setInt(2, Integer.parseInt(connectionTypeId));
				callable.setInt(3, 0);
				callable.registerOutParameter(4, java.sql.Types.INTEGER);
				callable.executeUpdate();
				int connection_id = callable.getInt(4);
				System.out.println("-------------------------------------------");
				System.out.println("Your New Connection id is : " + connection_id);
				System.out.println("-------------------------------------------");
			}
		}

	}// add() ends

	@Override
	public void remove(int inputId) throws SQLException {
		CallableStatement callable = con.prepareCall("{call doesConnectionIdExists(?,?)}");
		callable.setInt(1, inputId);
		callable.registerOutParameter(2, java.sql.Types.VARCHAR);
		callable.executeUpdate();
		String recordExists = callable.getString(2);

		if (recordExists.equals("True")) {
			callable = con.prepareCall("{call deleteConnectionByConnectionId(?)}");
			callable.setInt(1, inputId);
			ResultSet rs = callable.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
		} else {
			System.out.println("Input Connection Id not exists");
		}

	}

	@Override
	public void generateBillByConnectionId(int inputId, int currentReading) throws SQLException {
		CallableStatement callable = con.prepareCall("{call generateBillByConnectionId(?,?,?)}");
		callable.setInt(1, inputId);
		callable.setInt(2, currentReading);
		callable.registerOutParameter(3, java.sql.Types.VARCHAR);
		callable.executeUpdate();
		String result = callable.getString(3);

		if (result.equals("True")) {
			System.out.println("Bill for connection id " + inputId + " is generated just now ");
		} else {
			System.out.println("Bill generation failed");
		}

	}

	@Override
	public void generateBillsForAllConnections(Scanner sc) throws SQLException {
		this.refreshRecords();

		int id, currentReading;
		String reading;
		for (int i = 0; i < list.size(); i++) {
			Connections obj = list.get(i);
			id = obj.getId();
			System.out.println("\nenter current reading for connection id : " + id);
			reading = sc.nextLine();
			currentReading = Integer.parseInt(reading);
			this.generateBillByConnectionId(id, currentReading);

		}
	}

	@Override
	public void billsOfAllConsumers() throws SQLException {

		CallableStatement callable = con.prepareCall("{call billsOfAllConsumers()}");
		ResultSet rs = callable.executeQuery();
		String temp = "";
		int id, year, month, connectionId, consumerId, reading, billedUnits;
		double amount;
		String dateTime, type;

		System.out.println("\nBills of all consumers");
		System.out.println("\nId\tYear\tMonth\tDateTime\tConnectionId\tConsumerId\tType\tReading\tBilledUnits\tAmount");
		while (rs.next()) {
			id = rs.getInt(1);
			year = rs.getInt(2);
			month = rs.getInt(3);
			dateTime = rs.getString(4);
			connectionId = rs.getInt(5);
			consumerId = rs.getInt(6);
			type = rs.getString(7);
			reading = rs.getInt(8);
			billedUnits = rs.getInt(9);
			amount = rs.getDouble(10);

			temp = id + " | " + year + " | " + month + " | " + dateTime + " | " + connectionId + " | " + consumerId
					+ " | " + type + " | " + reading + " | " + billedUnits + " | " + amount;
			System.out.println(temp);
		}
	}

	@Override
	public void billsByCityAndArea(String area, String city) throws SQLException {

		CallableStatement callable = con.prepareCall("{call billsByCityAndArea(?,?)}");
		callable.setString(1, area);
		callable.setString(2, city);
		ResultSet rs = callable.executeQuery();
		String temp = "";
		int id, year, month, connectionId, consumerId, reading, billedUnits;
		double amount;
		String dateTime, type;

		System.out.println("\nBills of all consumers for entered area and city");
		System.out.println("\nId\tYear\tMonth\tDateTime\tConnectionId\tConsumerId\tType\tReading\tBilledUnits\tAmount");
		while (rs.next()) {
			id = rs.getInt(1);
			year = rs.getInt(2);
			month = rs.getInt(3);
			dateTime = rs.getString(4);
			connectionId = rs.getInt(5);
			consumerId = rs.getInt(6);
			type = rs.getString(7);
			reading = rs.getInt(8);
			billedUnits = rs.getInt(9);
			amount = rs.getDouble(10);

			temp = id + " | " + year + " | " + month + " | " + dateTime + " | " + connectionId + " | " + consumerId
					+ " | " + type + " | " + reading + " | " + billedUnits + " | " + amount;
			System.out.println(temp);
		}
	}

	@Override
	public void billsByMonthAndYear(String inputYear, String inputMonth) throws SQLException {

		CallableStatement callable = con.prepareCall("{call billsByMonthAndYear(?,?)}");
		callable.setString(1, inputYear);
		callable.setString(2, inputMonth);
		ResultSet rs = callable.executeQuery();
		String temp = "";
		int id, year, month, connectionId, consumerId, reading, billedUnits;
		double amount;
		String dateTime, type;

		System.out.println("\nBills of all consumers for entered year and month");
		System.out.println("\nId\tYear\tMonth\tDateTime\tConnectionId\tConsumerId\tType\tReading\tBilledUnits\tAmount");
		while (rs.next()) {
			id = rs.getInt(1);
			year = rs.getInt(2);
			month = rs.getInt(3);
			dateTime = rs.getString(4);
			connectionId = rs.getInt(5);
			consumerId = rs.getInt(6);
			type = rs.getString(7);
			reading = rs.getInt(8);
			billedUnits = rs.getInt(9);
			amount = rs.getDouble(10);

			temp = id + " | " + year + " | " + month + " | " + dateTime + " | " + connectionId + " | " + consumerId
					+ " | " + type + " | " + reading + " | " + billedUnits + " | " + amount;
			System.out.println(temp);
		}

	}

	// for writing in human readable file
	public void writeToFile() throws SQLException {
		CallableStatement callable = con.prepareCall("{call billsOfAllConsumers()}");
		ResultSet rs = callable.executeQuery();
		String temp = "";
		int id, year, month, connectionId, consumerId, reading, billedUnits;
		double amount;
		String dateTime, type;

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("\tYear\tMonth\tDateTime\tConnectionId\tConsumerId\tType\tReading\tBilledUnits\tAmount");
		arr.add("");
		while (rs.next()) {
			id = rs.getInt(1);
			year = rs.getInt(2);
			month = rs.getInt(3);
			dateTime = rs.getString(4);
			connectionId = rs.getInt(5);
			consumerId = rs.getInt(6);
			type = rs.getString(7);
			reading = rs.getInt(8);
			billedUnits = rs.getInt(9);
			amount = rs.getDouble(10);

			temp = id + " | " + year + " | " + month + " | " + dateTime + " | " + connectionId + " | " + consumerId
					+ " | " + type + " | " + reading + " | " + billedUnits + " | " + amount;
			arr.add(temp);
		}

		// OutputStream: Writing into the File
		// InputStream: Reading from the File
		OutputStream outStream = null;
		Writer writer = null;
		try {
			outStream = new FileOutputStream("C:\\Users\\sandeep singh\\Desktop\\EMS\\Bills.txt");
			writer = new OutputStreamWriter(outStream);
			writer.write("Hello Everyone!!");
			for (int i = 0; i < arr.size(); i++) {
				writer.write(arr.get(i) + "\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				writer.close();
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
