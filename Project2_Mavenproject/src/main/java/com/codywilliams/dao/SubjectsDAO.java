package com.codywilliams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.codywilliams.models.Subjects;

public class SubjectsDAO {

	public List<Subjects> getAllSubjects(){
		
		List<Subjects> subjectsList = new ArrayList<Subjects>();
		
		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
					
					PreparedStatement statement = connection.prepareStatement("SELECT * FROM Subjects;");
					
					ResultSet rs = statement.executeQuery();
					while(rs.next()){
						Subjects subjects = new Subjects();
						subjects.setSubName(rs.getString(1));
						subjects.setSubClass(rs.getString(2));
						System.out.println(subjects);
						subjectsList.add(subjects);
					}
					connection.close();
					
				}catch (Exception ex) {
					System.out.println(ex.getMessage());
			}
			
				return subjectsList;
				
			
			}
	
	public void insertSubject(Subjects sub) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
		PreparedStatement statement=connection.prepareStatement("INSERT INTO Subjects(SubName , SubClass ) values(? , ?)");
		statement.setString(1, sub.getSubName());
		statement.setString(2, sub.getSubClass());
		int rows = statement.executeUpdate();
		if(rows != 1) {
			System.out.println("Student inserted succesfully");
		}else {
			System.out.println("There is an Error while Inserting Student");
		}
		connection.close();
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}


	}
}