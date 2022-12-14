package emsDriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connectivity.*;
import daoImplementations.*;
import daoInterfaces.*;
import daoImplementations.*;
import dbObjectClasses.*;
import ems.*;

public class Main {
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

//		int portNumber = 3306;
//		String dbName = "electricity_management_system";
//		String user = "root";
//		String password = "1234";

		System.out.println("Enter port number : ");
		int portNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter database name : ");
		String dbName = sc.next();
		sc.nextLine();
		System.out.println("Enter user name : ");
		String user = sc.nextLine();
		System.out.println("Enter password : ");
		String password = sc.nextLine();

		EMSConnection.setPortNumber(portNumber + "");
		EMSConnection.setDBName(dbName);
		EMSConnection.setUser(user);
		EMSConnection.setPassword(password);
		EMSConnection.getConnection();
		System.out.println("\nConnection Established wth database...\n\n");

		AbstractConnectionEms.con = EMSConnection.getConnection();

		ConnectionsDAOImp connectionsDAOImpObj = new ConnectionsDAOImp();

		// lambda expression
		UtilityFunctionalInterface lambdaExpressionObj = (id) -> {
			ConnectionsDAOImp abc = new ConnectionsDAOImp();
			try {
				abc.refreshRecords();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < abc.getList().size(); i++) {
				if (id == abc.getList().get(i).getId()) {
					return true;
				}
			}
			return false;
		};

		// switch case below
		char choice;
		int inputId, reading;
		String area, city, year, month;
		do {
			System.out.println("1. Register a consumer");
			System.out.println("2. Check if the connection id exists or not");
			System.out.println("3. Generate bill for specific connection Id");
			System.out.println("4. Generate bills for all connection Id's");
			System.out.println("5. Bills of all consumers");
			System.out.println("6. Bills of consumers for specific area and city");
			System.out.println("7. Bills of consumers for specific year and month");
			System.out.println("8. Create a file that contains list of all bills ");

			System.out.println("\nSelect Your Option from above operations : ");
			String option = sc.nextLine();
			switch (option) {
			case "1":
				connectionsDAOImpObj.add(sc);
				break;
			case "2":
				System.out.println("\nEnter connection id : ");
				String c = sc.nextLine();
				inputId = Integer.parseInt(c);
				if (lambdaExpressionObj.check(inputId)) {
					System.out.println("\nConnection Id exists .....\n");
				} else {
					System.out.println("\nConnection Id not exists .....\n");
				}
				break;
			case "3":
				System.out.println("\nEnter connection id : ");
				String a = sc.nextLine();
				System.out.println("\nEnter current reading of meter : ");
				String b = sc.nextLine();

				inputId = Integer.parseInt(a);
				reading = Integer.parseInt(b);
				connectionsDAOImpObj.generateBillByConnectionId(inputId, reading);
				break;
			case "4":
				connectionsDAOImpObj.generateBillsForAllConnections(sc);
				break;
			case "5":
				connectionsDAOImpObj.billsOfAllConsumers();
				break;
			case "6":
				System.out.println("\nEnter your area name : ");
				area = sc.nextLine();
				System.out.println("\nEnter your city name : ");
				city = sc.nextLine();
				connectionsDAOImpObj.billsByCityAndArea(area, city);
				break;
			case "7":
				System.out.println("\nEnter year : ");
				year = sc.nextLine();
				System.out.println("\nEnter month : ");
				month = sc.nextLine();
				connectionsDAOImpObj.billsByMonthAndYear(year, month);
				break;
			case "8":
				connectionsDAOImpObj.writeToFile();
				System.out.println("File written Successfully check the directory to access it...");
				break;
			default:
				System.out.println("Invalid choice!!!");
				break;

			}

			System.out.println("Press 'Y' to continue");
			choice = sc.nextLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

}
