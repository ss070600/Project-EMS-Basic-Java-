package daoInterfaces;

import java.sql.SQLException;
import java.util.Scanner;

public interface ConnectionsDAOI extends UtilityInterface {
	public void add(Scanner sc) throws SQLException;

	public void remove(int inputId) throws SQLException;

	public void generateBillByConnectionId(int inputId, int currentReading) throws SQLException;

	public void generateBillsForAllConnections(Scanner sc) throws SQLException;

	public void billsOfAllConsumers() throws SQLException;

	public void billsByCityAndArea(String area, String city) throws SQLException;

	public void billsByMonthAndYear(String year, String month) throws SQLException;
}
