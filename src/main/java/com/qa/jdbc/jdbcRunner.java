package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_schema","root", "pass");
				Statement stmnt = conn.createStatement();
				ResultSet results = stmnt.executeQuery("SELECT * FROM pet");){
			while (results.next()) {
				int id = results.getInt(1);
				String name =results.getString("name");
				int age =results.getInt(3);
				String colour =results.getString("colour");
				String breed =results.getString("breed");
				System.out.println(id+name+age+colour+breed);
			}
			
			            		                          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
