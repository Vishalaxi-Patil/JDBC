package com.xworkz.matrimony1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.xworkz.matrimony.dto.Bride;
import com.xworkz.matrimony1.dto.BrideDTO;

public class GetAllBridesApplication {
	
	

	public static void main(String[] args)
	{
		
		Connection connect=null;
		
		//List<BrideDTO> list=new ArrayList<BrideDTO>();
		try {
			
			//Connection connect=null;;
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Vkpatil1@2*");
			System.out.println("Connection sucessfully");
			
			Statement stmt=connect.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from  matrimony.bride");
			BrideDTO brideDTO=new BrideDTO();
			
			while(resultSet.next()) {
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
				//list.add(brideDTO);
				System.out.println(brideDTO);//to get all record
			}
			//System.out.println(brideDTO); to get 1 record
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connect.close();
				System.out.println("connection close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}

