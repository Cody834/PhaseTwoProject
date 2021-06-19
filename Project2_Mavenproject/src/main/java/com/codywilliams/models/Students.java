package com.codywilliams.models;

public class Students {

		private int studID;
		private String studName;
		private String studClass;
		
		
		public int getStudID() {
			return studID;
		}
		public void setStudID(int studID) {
			this.studID = studID;
		}
		
		public String getStudName() {
			return studName;
		}
		
		public void setStudName(String studName) {
			this.studName = studName;
		}
		
		public String getStudClass() {
			return studClass;
		}
		
		public void setClass(String studClass) {
			this.studClass = studClass;
		}
		@Override
		public String toString() {
			return "Students [studID=" + studID + ", studName=" + studName + ", studClass=" + studClass + "]";
		}
		
		}



