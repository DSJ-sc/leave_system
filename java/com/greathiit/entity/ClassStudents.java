package com.greathiit.entity;

import java.util.List;

public class ClassStudents {
	private String className;
	private List<String> studentName;
	private List<String> studentSno;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<String> getStudentName() {
		return studentName;
	}
	public void setStudentName(List<String> studentName) {
		this.studentName = studentName;
	}
	public List<String> getStudentSno() {
		return studentSno;
	}
	public void setStudentSno(List<String> studentSno) {
		this.studentSno = studentSno;
	}
	
}
