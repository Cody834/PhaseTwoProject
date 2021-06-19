package com.codywilliams.dao;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.codywilliams.models.Teachers;


public class TeachersDAO {

	

	
			public List<Teachers> getAllTeachers(){
				
				List<Teachers> teachersList = new ArrayList<Teachers>();
				
				try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
							
							PreparedStatement statement = connection.prepareStatement("SELECT * FROM Teachers;");
							
							ResultSet rs = statement.executeQuery();
							while(rs.next()){
								Teachers teachers = new Teachers();
								teachers.setTeaID(rs.getInt(1));
								teachers.setTeaName(rs.getString(2));
								teachers.setTeaClass(rs.getString(3));
								System.out.println(teachers);
								teachersList.add(teachers);
							}
							connection.close();
							
						}catch (Exception ex) {
							System.out.println(ex.getMessage());
					}
					
						return teachersList;
						
					
					}
			
			public void insertTeacher(Teachers tea) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
				PreparedStatement statement=connection.prepareStatement("INSERT INTO Teachers(TeaName ,TeaClass ) values (?, ? )");
				statement.setString(1, tea.getTeaName());
				statement.setString(2, tea.getTeaClass());
				int rows = statement.executeUpdate();
				if(rows > 1) {
					System.out.println("Teacher inserted succesfully");
				}else {
					System.out.println("There is an Error while Inserting Teacher");
				}
				connection.close();
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}


			}
	}

