package com.codywilliams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codywilliams.models.Classes;

public class ClassesDAO {

	public static List<Classes> getAllClasses(){
		
		List<Classes> classesList = new ArrayList<Classes>();
		
		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
					
					PreparedStatement statement = connection.prepareStatement("SELECT * FROM Classes;");
					
					ResultSet rs = statement.executeQuery();
					while(rs.next()){
						Classes classes = new Classes();
						classes.setClsLetter(rs.getString(1));
						System.out.println(classes);
						classesList.add(classes);
					}
					connection.close();
					
				}catch (Exception ex) {
					System.out.println(ex.getMessage());
			}
			
				return classesList;
				
			
			}
	
	public static void insertClass(Classes cls) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
		PreparedStatement statement=connection.prepareStatement("INSERT INTO Classes(classLetter) values (?)");
		statement.setString(1, cls.getClsLetter());
		int rows = statement.executeUpdate();
		if(rows > 1) {
			System.out.println("Class inserted succesfully");
		}else {
			System.out.println("There is an Error while Inserting Class");
		}
		connection.close();
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}


	}
}

