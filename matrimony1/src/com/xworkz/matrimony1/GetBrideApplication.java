package com.xworkz.matrimony1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.matrimony1.dto.BrideDTO;

public class GetBrideApplication {

	public static void main(String[] args) {
		// before loading driver first check driver is present are not set java built
		// path with jar file

//		// load and register done by SPI
//		try {
//			//not neccessayClass.forName("com.mysql.jdbc.Driver");// checked exception so caller methods shold responsible to handle
//			System.out.println("Driver loaded successfully");
//			//com.mysql.cj.jdbc.Driver new driver class
//			//com.mysql.jdbc.Driver older driver
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// getConnection method driver manager class
		// getConnection 3 overloaded version

		// step 3: creating statement
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Vkpatil1@2*");
			System.out.println("Sucessfully connected with database");
			// using connection object create statement
			Statement stmt = connection.createStatement();
			// craeteStatement is abstract method in connection interface-java.sql
			// impleneation prsrent in  com.mysql.cj.jdbc.JdbcConnection
			ResultSet resultSet = stmt.executeQuery("select * from  matrimony.bride where id=1");
			// result set is a table of data
			// result maintains one cursor
			// resultSet.next();//move cursor to next position(current record)
			// create bride obect
			BrideDTO brideDTO = new BrideDTO();
			while (resultSet.next()) {
				// map resultset to java Object
				brideDTO.setId(resultSet.getInt(1));
				brideDTO.setName(resultSet.getString(2));
				brideDTO.setAge(resultSet.getInt(3));
				brideDTO.setHeight(resultSet.getDouble(4));
				brideDTO.setWeight(resultSet.getDouble(5));
				brideDTO.setQualification(resultSet.getString(6));
				brideDTO.setCast(resultSet.getString(7));
				brideDTO.setPhoneNumber(resultSet.getString(8));
				brideDTO.setAddress(resultSet.getString(9));
				brideDTO.setOccupation(resultSet.getString(10));
				brideDTO.setExpectation(resultSet.getString(11));
				brideDTO.setSalary(resultSet.getDouble(12));

			}
			System.out.println(brideDTO);
		} catch (SQLException e) {
			System.out.println("failed to connect database");
			e.printStackTrace();
		}finally {
			//close connection
			try {
				connection.close();//complie expection so handle that is SQLException
				System.out.println("connection close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
