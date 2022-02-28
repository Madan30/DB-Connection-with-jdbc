package com.NepalCode.DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LbefDao {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/studentdatabase";
	private String username = "root";
	private String password = "root";

	private Connection con;

	public void createDBConnetion() throws ClassNotFoundException, SQLException {
		// load the driver
		Class.forName(driver);

		// get the connection
		con = DriverManager.getConnection(url, username, password);
	}

	public void selectAllRow() throws SQLException, ClassNotFoundException {

		createDBConnetion();
		// create statement
		Statement stmt = con.createStatement();

		// set the result
		ResultSet rs = stmt.executeQuery("SELECT * FROM studentdatabase.studentinfo");

		while (rs.next()) {
			int studentid = rs.getInt(1);
			String studentname = rs.getString(2);
			String phonenum = rs.getString(3);
			double fees = rs.getDouble(4);

			System.out.println(studentid + " " + studentname + " " + phonenum + " " + fees);
		}
		
		// closing connection
		closeConnection();

	}
	
	
	public void deleteLbefData(int studentId) throws SQLException {
		// create statement
		Statement stmt = con.createStatement();
		
		// execute delete query
		stmt.executeUpdate("delete from studentdatabase.studentinfo where studentid is: " + studentId);
		
		// deleting record of lbef student
		System.out.println("Deleting student data from lbef college");
		
		// closing connection
		closeConnection();
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}

}
