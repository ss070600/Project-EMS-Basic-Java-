package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EMSConnection {
	private static Connection con = null;
	private static String DBName, portNumber, user, password;
	private static boolean status_isConnectionObjectCreated;

	private EMSConnection() {
		super();
	}

	public static String getDBName() {
		return DBName;
	}

	public static void setDBName(String dBName) {
		DBName = dBName;
	}

	public static String getPortNumber() {
		return portNumber;
	}

	public static void setPortNumber(String portNumber) {
		EMSConnection.portNumber = portNumber;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		EMSConnection.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		EMSConnection.password = password;
	}

	public static boolean isStatus_isConnectionObjectCreated() {
		return status_isConnectionObjectCreated;
	}

	public static void setStatus_isConnectionObjectCreated(boolean status_isConnectionObjectCreated) {
		EMSConnection.status_isConnectionObjectCreated = status_isConnectionObjectCreated;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + EMSConnection.getPortNumber() + "/" + EMSConnection.getDBName();
			con = DriverManager.getConnection(url, EMSConnection.getUser(), EMSConnection.getPassword());
			status_isConnectionObjectCreated = true;
		}
		return con;
	}

}
