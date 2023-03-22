package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
	
	public List<Pet> read(){
		List<Pet> pets = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_schema","root", "pass");
				Statement stmnt = conn.createStatement();
				ResultSet results = stmnt.executeQuery("SELECT * FROM pet");){
			while (results.next()) {
				int id = results.getInt(1);
				String name =results.getString("name");
				int age =results.getInt(3);
				String colour =results.getString("colour");
				String breed =results.getString("breed");
				//System.out.println(id+name+age+colour+breed);
				pets.add(new Pet(id,name,age,colour,breed));
			}	
			            		                          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pets;
	}
	
	public int create(String name, int age, String colour, String breed) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_schema","root", "pass");
				PreparedStatement stmnt = conn
						.prepareStatement("INSERT into pet (name,age,colour,breed) VALUES(?,?,?,?)");){
			stmnt.setString(1, name);
			stmnt.setInt(2,age);
			stmnt.setString(3, colour);
			stmnt.setString(4, breed);	
			return stmnt.executeUpdate();
			            		                          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteById(int id) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_schema","root", "pass");
				PreparedStatement stmnt = conn
						.prepareStatement("Delete from pet where petId = ?");){
			stmnt.setInt(1,id);
			return stmnt.executeUpdate();
			            		                          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;		
	}
	
	public int updateRowByName(String name, int age, String colour, String breed) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_schema","root", "pass");
				PreparedStatement stmnt = conn
						.prepareStatement("Update pet set age = ?, colour=?, breed=? where name = ?");){
			stmnt.setString(4, name);
			stmnt.setInt(1,age);
			stmnt.setString(2, colour);
			stmnt.setString(3, breed);	
			return stmnt.executeUpdate();
			            		                          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
