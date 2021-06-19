package com.codywilliams.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codywilliams.models.Students;

public class StudentsDAO {

		public List<Students> getAllStudents(){
			
			List<Students> studentsList = new ArrayList<Students>();
			
			try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
						
						PreparedStatement statement = connection.prepareStatement("SELECT * FROM Students;");
						
						ResultSet rs = statement.executeQuery();
						while(rs.next()){
							Students students = new Students();
							students.setStudID(rs.getInt(1));
							students.setStudName(rs.getString(2));
							students.setClass(rs.getString(3));
							System.out.println(students);
							studentsList.add(students);
						}
						connection.close();
						
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
				}
				
					return studentsList;
					
				
				}
		
		public void insertStudent(Students stud) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
			PreparedStatement statement=connection.prepareStatement("INSERT INTO Students(StudID, StudName , Class ) values (? , ? , ?)");
			statement.setInt(1, stud.getStudID());
			statement.setString(2, stud.getStudName());
			statement.setString(3, stud.getStudClass());
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