package emsDriver;

/*
 * This class file only tests singleton connection object and methods of Utility Interface
*/
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connectivity.*;
import daoImplementations.*;
import daoInterfaces.*;
import daoImplementations.*;
import dbObjectClasses.*;
import ems.*;

public class MainForTestingDB_DAO_Classes {
	public static void welcomeMessage() {
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t<<<<<<<<\t  Electricity Management System - Team 5\t>>>>>>>>");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Main.welcomeMessage();

		Scanner sc = new Scanner(System.in);

		int portNumber = 3306;
		String dbName = "electricity_management_system";
		String user = "root";
		String password = "1234";

		EMSConnection.setPortNumber(portNumber + "");
		EMSConnection.setDBName(dbName);
		EMSConnection.setUser(user);
		EMSConnection.setPassword(password);
		EMSConnection.getConnection();
		System.out.println("Connection Established !!");

		// initializing connection object that will be used everywhere
		AbstractConnectionEms.con = EMSConnection.getConnection();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Test to check wether we are getting same connection object everytime\n");

		AbstractConnectionEms abstractClassEmsDAOImpObj = new ConsumerDAOImp();
		System.out.println(abstractClassEmsDAOImpObj.con);

		ConsumerDAOImp consumerDAOImpObj = new ConsumerDAOImp();
		System.out.println(consumerDAOImpObj.con);

		AddressDAOImp addressDAOImpObj = new AddressDAOImp();
		System.out.println(addressDAOImpObj.con);

		System.out.println();

		if (abstractClassEmsDAOImpObj.con == consumerDAOImpObj.con && consumerDAOImpObj.con == addressDAOImpObj.con)
			System.out.println("same connection object is getting returned everytime");

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("Testing refreshRecords(),getAll(),get(int) for AddressDAOImp");
		AddressDAOImp object1 = new AddressDAOImp();
		object1.refreshRecords();
		object1.getAll();
		System.out.println();
		object1.get(3);

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("Testing refreshRecords(),getAll(),get(int) for ConsumerDAOImp");

		ConsumerDAOImp object2 = new ConsumerDAOImp();
		object2.refreshRecords();
		object2.getAll();
		System.out.println();
		object2.get(12);

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("Testing refreshRecords(),getAll(),get(int) for ConnectionsDAOImp");

		ConnectionsDAOImp object3 = new ConnectionsDAOImp();
		object3.refreshRecords();
		object3.getAll();
		System.out.println();
		object3.get(3);

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("Testing refreshRecords(),getAll(),get(int) for ConnectionTypeDAOImp");

		ConnectionTypeDAOImp object4 = new ConnectionTypeDAOImp();
		object4.refreshRecords();
		object4.getAll();
		System.out.println();
		object4.get(2);

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("Testing refreshRecords(),getAll(),get(int) for BillDAOImp");

		BillDAOImp object5 = new BillDAOImp();
		object5.refreshRecords();
		object5.getAll();
		System.out.println();
		object5.get(3);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Testing over!!!");
		System.out.println("--------------------------------------------------------------------------------");

	}

}
