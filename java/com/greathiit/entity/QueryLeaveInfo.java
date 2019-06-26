package com.greathiit.entity;

/**
 * @author 邓世江
 * @date 2018年11月13日 下午3:13:13
 * 
 */
public class QueryLeaveInfo {
	/**编号**/
	private String userNum;
	/**姓名**/
	private String userName;
	/**性别**/
	private String userSex;
	/**请假日期**/
	private String leaveTime;
	/**开始时间**/
	private String leaveStartTime;
	/**结束时间**/
	private String leaveEndTime;
	/**班级**/
	private String className;
	/**学院*/
	private String faculty;
	/**专业*/
	private String specialty;
	public QueryLeaveInfo() {
	}
	
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getLeaveStartTime() {
		return leaveStartTime;
	}
	public void setLeaveStartTime(String leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}
	public String getLeaveEndTime() {
		return leaveEndTime;
	}
	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	@Override
	public String toString() {
		return "QueryLeaveInfo [userNum=" + userNum + ", userName=" + userName + ", userSex=" + userSex + ", leaveTime="
				+ leaveTime + ", leaveStartTime=" + leaveStartTime + ", leaveEndTime=" + leaveEndTime + ", className="
				+ className + ", faculty=" + faculty + ", specialty=" + specialty + "]";
	}
	

	
}