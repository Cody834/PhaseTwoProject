package com.codywilliams.models;

public class Teachers {

	private int teaID;
	private String teaName;
	private String teaClass;
	
	public int getTeaID() {
		return teaID;
	}
	public void setTeaID(int teaID) {
		this.teaID = teaID;
	}
	
	public String getTeaName() {
		return teaName;
	}
	
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaClass() {
		return teaClass;
	}
	public void setTeaClass(String teaClass) {
		this.teaClass = teaClass;
	}
	@Override
	public String toString() {
		return "Teachers [teaID=" + teaID + ", teaName=" + teaName + ", teaClass=" + teaClass + "]";
	}
	
	
	
	
	}



