package com.greathiit.entity;

/**
 * @author 邓世江
 * @date 2018年11月7日 下午7:54:00
 * 
 */
public class StudentClass {
	/**班级号**/
	private String className;
	/**班主任**/
	private String classHeadTeacher;
	/**导员**/
	private String classGuideTeacher;
	/**专业主任**/
	private String specialtyTeacherNum;
	/**所属专业**/
	private String specialtyName;
	/**专业id**/
	private String specialtyId;
	/**院长**/
	private String facultyTeacherNum;
	/**所属学院**/
	private String facultyName;
	/**班级人数**/
	private Integer classStudentNum;
	/**年级**/
	private String 	classGrade;
	public StudentClass() {
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassHeadTeacher() {
		return classHeadTeacher;
	}
	public void setClassHeadTeacher(String classHeadTeacher) {
		this.classHeadTeacher = classHeadTeacher;
	}
	public String getClassGuideTeacher() {
		return classGuideTeacher;
	}
	public void setClassGuideTeacher(String classGuideTeacher) {
		this.classGuideTeacher = classGuideTeacher;
	}
	
	public String getFacultyTeacherNum() {
		return facultyTeacherNum;
	}
	public void setFacultyTeacherNum(String facultyTeacherNum) {
		this.facultyTeacherNum = facultyTeacherNum;
	}
	
	public String getSpecialtyTeacherNum() {
		return specialtyTeacherNum;
	}
	public void setSpecialtyTeacherNum(String specialtyTeacherNum) {
		this.specialtyTeacherNum = specialtyTeacherNum;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public String getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public Integer getClassStudentNum() {
		return classStudentNum;
	}
	public void setClassStudentNum(Integer classStudentNum) {
		this.classStudentNum = classStudentNum;
	}
	public String getClassGrade() {
		return classGrade;
	}
	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}
	
	
}
	