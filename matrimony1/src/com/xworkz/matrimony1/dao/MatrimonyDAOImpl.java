package com.xworkz.matrimony1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xworkz.matrimony1.dto.BrideDTO;
import static com.xworkz.matrimony1.constant.Constants.*;

public class MatrimonyDAOImpl implements MatrimonyDAO {

	@Override
	public BrideDTO getById(int id) {
		BrideDTO brideDTO = new BrideDTO();
		try {
			Connection connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			Statement stmt = connect.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from  matrimony.bride where id=" + id);

			resultSet.next();
			// map resultset to java Object i,e brideDTO object
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return brideDTO;
	}

	@Override
	public BrideDTO getAllBride() {
		BrideDTO brideDTO = new BrideDTO();
		try {
			Connection connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			Statement stmt = connect.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from  matrimony.bride");

			while (resultSet.next()) {
				// map resultset to java Object i,e brideDTO object
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
				System.out.println(brideDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return brideDTO;
	}

	@Override
	public int create(BrideDTO brideDTO) {
		int result = 0;

		try {
			Connection connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement preparedStatement = connect
					.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, brideDTO.getId());
			preparedStatement.setString(2, brideDTO.getName());
			preparedStatement.setInt(3, brideDTO.getAge());
			preparedStatement.setDouble(4, brideDTO.getHeight());
			preparedStatement.setDouble(5, brideDTO.getWeight());
			preparedStatement.setString(6, brideDTO.getQualification());
			preparedStatement.setString(7, brideDTO.getCast());
			preparedStatement.setString(8, brideDTO.getPhoneNumber());
			preparedStatement.setString(9, brideDTO.getAddress());
			preparedStatement.setString(10, brideDTO.getOccupation());
			preparedStatement.setString(11, brideDTO.getExpectation());
			preparedStatement.setDouble(12, brideDTO.getSalary());
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Failed to connect database");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updatePhoneById(int id, String phoneNo) {
		BrideDTO brideDTO = new BrideDTO();
		int result = 0;
		try {
			Connection connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement preparedStatement = connect
					.prepareStatement("update matrimony.bride set phone_number=? where id=?");
			preparedStatement.setString(1, phoneNo);
			preparedStatement.setInt(2, id);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteById(int id) {
		int result = 0;
		try {
			Connection connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement preparedStatement = connect.prepareStatement("delete from matrimony.bride where id=?");
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int[] insertBrides(List<BrideDTO> brides) {
		int[] results = new int[brides.size()];
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			Statement statement = connection.createStatement();

			for (BrideDTO brideDTO : brides) {

				String query = String.format(INSERT_QUERY, brideDTO.getId(), brideDTO.getName(), brideDTO.getAge(),
						brideDTO.getHeight(), brideDTO.getWeight(), brideDTO.getQualification(), brideDTO.getCast(),
						brideDTO.getPhoneNumber(), brideDTO.getAddress(), brideDTO.getOccupation(),
						brideDTO.getExpectation(), brideDTO.getSalary());

				statement.addBatch(query);
			}
			results = statement.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int[] updateBrides(List<BrideDTO> brides) {
		int[] results = new int[brides.size()];
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
			for (BrideDTO brideDTO : brides) {
				preparedStatement.setString(1, brideDTO.getQualification());
				preparedStatement.setDouble(2, brideDTO.getSalary());
				preparedStatement.setInt(3, brideDTO.getId());
				preparedStatement.addBatch();

			}
			results = preparedStatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;
	}

	@Override
	public int[] deleteAllBrides(List<Integer> id) {
		int[] results = new int[id.size()];

		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_BRIDES);
			for (Integer integer : id) {

				preparedStatement.setInt(1, intseger);

				results = preparedStatement.executeBatch();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;
	}

}
