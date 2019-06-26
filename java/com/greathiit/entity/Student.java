package com.greathiit.entity;

import java.util.List;


/**
 * @author 邓世江
 * @date 2018年11月7日 上午11:10:45
 * 
 */
public class Student {
	/**学号*/
	private String studentSno;
	/**姓名*/
	private String studentName;
	/**年龄*/
	private Integer studentAge;
	/**性别**/
	private String studentSex;
	/**照片*/
	private String studentPhoto;
	/**身份证号*/
	private String studentId;
	/**班级*/
	private StudentClass studentClass;
	/**电话*/
	private String studentPhone;
	/**公寓**/
	private String studentApartment;
	private List<StudentLeaveInfo> studentLeave;
 	public Student() {
		
	}
	public String getStudentSno() {
		return studentSno;
	}
	public void setStudentSno(String studentSno) {
		this.studentSno = studentSno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentPhoto() {
		return studentPhoto;
	}
	public void setStudentPhoto(String studentPhoto) {
		this.studentPhoto = studentPhoto;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public StudentClass getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentApartment() {
		return studentApartment;
	}
	public void setStudentApartment(String studentApartment) {
		this.studentApartment = studentApartment;
	}
	public List<StudentLeaveInfo> getStudentLeave() {
		return studentLeave;
	}
	public void setStudentLeave(List<StudentLeaveInfo> studentLeave) {
		this.studentLeave = studentLeave;
	}
	@Override
	public String toString() {
		return "Student [studentSno=" + studentSno + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentSex=" + studentSex + ", studentPhoto=" + studentPhoto + ", studentId=" + studentId
				+ ", studentClass=" + studentClass + ", studentPhone=" + studentPhone + ", studentApartment="
				+ studentApartment + ", studentLeave=" + studentLeave + "]";
	}
	
	
}
