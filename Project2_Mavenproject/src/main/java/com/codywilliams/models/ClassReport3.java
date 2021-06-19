package com.codywilliams.models;

public class ClassReport3 {
	private String clsSubject;
	private String clsStudents;
	private String clsTeachers;
		public String getClsSubject() {
		return clsSubject;
	}
	public void setClsSubject(String clsSubject) {
		this.clsSubject = clsSubject;
	}
	public String getClsStudents() {
		return clsStudents;
	}
	public void setClsStudents(String clsStudents) {
		this.clsStudents = clsStudents;
	}
	public String getClsTeachers() {
		return clsTeachers;
	}
	public void setClsTeachers(String clsTeachers) {
		this.clsTeachers = clsTeachers;
	}
	@Override
	public String toString() {
		return "ClassReport [subject=" + clsSubject + ", students=" + clsStudents + ", teachers="
				+ clsTeachers + "]";
	}
	
	
	
}

