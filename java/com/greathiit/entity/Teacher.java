package com.greathiit.entity;

import java.util.List;

/**
 * @author 邓世江
 * @date 2018年11月7日 上午11:23:50
 * 
 */
public class Teacher {
	/**教师登陆名*/
	private String teacherUname;
	/**教师密码*/
	private String teacherPassword;
	/**教师职工号*/
	private String teacherNum;
	/**教师姓名*/
	private String teacherName;
	/**教师性别*/
	private String teacherSex;
	/**教师所属学院*/
	private String teacherFaculty;
	/**教师所属专业*/
	private String teacherSpecialty;
	/**教师职务*/
	private String teacherPost;
	/**教师联系电话*/
	private String teacherPhone;
	/**专职教师*/
	private boolean fullTeacher;
	/**专业主任*/
	private String specialtyTeacherNum;
	/**院长*/
	private String facultyTeacherNum;
	private List<Syllabus> syllabus;
	private List<TeacherLeaveInfo> teacherLeaveInfo;
	/**
	 * 
	 */
	public Teacher() {
	}	
	

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public String getTeacherFaculty() {
		return teacherFaculty;
	}

	public void setTeacherFaculty(String teacherFaculty) {
		this.teacherFaculty = teacherFaculty;
	}
	public String getTeacherPost() {
		return teacherPost;
	}

	public void setTeacherPost(String teacherPost) {
		this.teacherPost = teacherPost;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}


	public boolean isFullTeacher() {
		return fullTeacher;
	}

	public void setFullTeacher(boolean fullTeacher) {
		this.fullTeacher = fullTeacher;
	}
	


	public List<Syllabus> getTeach() {
		return syllabus;
	}


	public void setTeach(List<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}


	public List<TeacherLeaveInfo> getTeacherLeaveInfo() {
		return teacherLeaveInfo;
	}


	public void setTeacherLeaveInfo(List<TeacherLeaveInfo> teacherLeaveInfo) {
		this.teacherLeaveInfo = teacherLeaveInfo;
	}

	public String getTeacherSpecialty() {
		return teacherSpecialty;
	}


	public void setTeacherSpecialty(String teacherSpecialty) {
		this.teacherSpecialty = teacherSpecialty;
	}


	public String getSpecialtyTeacherNum() {
		return specialtyTeacherNum;
	}


	public void setSpecialtyTeacherNum(String specialtyTeacherNum) {
		this.specialtyTeacherNum = specialtyTeacherNum;
	}


	public String getFacultyTeacherNum() {
		return facultyTeacherNum;
	}


	public void setFacultyTeacherNum(String facultyTeacherNum) {
		this.facultyTeacherNum = facultyTeacherNum;
	}


	public String getTeacherUname() {
		return teacherUname;
	}


	public void setTeacherUname(String teacherUname) {
		this.teacherUname = teacherUname;
	}


	public String getTeacherPassword() {
		return teacherPassword;
	}


	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}


	@Override
	public String toString() {
		return "Teacher [teacherUname=" + teacherUname + ", teacherPassword=" + teacherPassword + ", teacherNum="
				+ teacherNum + ", teacherName=" + teacherName + ", teacherSex=" + teacherSex + ", teacherFaculty="
				+ teacherFaculty + ", teacherSpecialty=" + teacherSpecialty + ", teacherPost=" + teacherPost
				+ ", teacherPhone=" + teacherPhone + ", fullTeacher=" + fullTeacher + ", specialtyTeacherNum="
				+ specialtyTeacherNum + ", facultyTeacherNum=" + facultyTeacherNum + ", syllabus=" + syllabus
				+ ", teacherLeaveInfo=" + teacherLeaveInfo + "]";
	}

}
