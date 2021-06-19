package com.codywilliams.models;

public class Subjects {

	private String subName;
	private String subClass;
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubClass() {
		return subClass;
	}
	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}
	@Override
	public String toString() {
		return "Subjects [subName=" + subName + ", subClass=" + subClass + "]";
	}
	
}
	


