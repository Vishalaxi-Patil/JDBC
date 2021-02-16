package com.xworkz.matrimony1.constant;

public class Constants {
	
	public static final String DB_URL="jdbc:mysql://localhost:3306";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="Vkpatil1@2*";
	public static final String INSERT_QUERY="insert into matrimony.bride values(%s,'%s',%s,%s,%s,'%s','%s','%s','%s','%s','%s',%s)";
	public static final String UPDATE_QUERY="update matrimony.bride set qualification=?,salary=? where id=?";
	public static final String DELETE_ALL_BRIDES="delete from matrimony.bride where id=?";
	

}
