package com.greathiit.entity;

/**
 * @author 邓世江
 * @date 2018年11月7日 下午8:02:41
 * 
 */
public class StudentLeaveInfo {
	private Integer studentLeaveId;
	/**编号**/
	private String studentLeaveNum;
	/**请假学生**/
	private String studentSno;
	/**班级**/
	private String className;
	private String studentName;
	/**学院**/
	private String specialty;
	/**专业**/
	private String faculty;
	/**请假类型**/
	private String leaveType;
	/**请假申请时间**/
	private String leaveApplyTime;
	/**请假理由**/
	private String leaveReason;
	/**请假证明**/
	private String leaveProve;
	/**请假开始时间**/
	private String leaveStartTime;
	/**请假结束时间**/
	private String leaveEndTime;
	/**家长电话**/
	private String parentPhone;
	/**安全保证协议**/
	private String leaveAgreement;
	/**一级审批**/
	private String leaveApprovalOne;
	/**一级审批时间**/
	private String leaveApprovalOneTime;
	/**一级审批备注**/
	private String leaveApprovalOneRemarks;
	/**二级审批**/
	private String leaveApprovalTwo;
	/**二级审批时间**/
	private String leaveApprovalTwoTime;
	/**二级审批备注**/
	private String leaveApprovalTwoRemarks;
	/**三级审批**/
	private String leaveApprovalThree;
	/**三级审批时间**/
	private String leaveApprovalThreeTime;
	/**三级审批备注**/
	private String leaveApprovalThreeRemarks;
	public StudentLeaveInfo() {

	}



	public String getClassName() {
		return className;
	}

	public String getStudentLeaveNum() {
		return studentLeaveNum;
	}


	public void setStudentLeaveNum(String studentLeaveNum) {
		this.studentLeaveNum = studentLeaveNum;
	}



	public void setClassName(String className) {
		this.className = className;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveApplyTime() {
		return leaveApplyTime;
	}

	public void setLeaveApplyTime(String leaveApplyTime) {
		this.leaveApplyTime = leaveApplyTime;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getLeaveProve() {
		return leaveProve;
	}

	public void setLeaveProve(String leaveProve) {
		this.leaveProve = leaveProve;
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

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getLeaveAgreement() {
		return leaveAgreement;
	}
	public void setLeaveAgreement(String leaveAgreement) {
		this.leaveAgreement = leaveAgreement;
	}



	public String getLeaveApprovalOneTime() {
		return leaveApprovalOneTime;
	}

	public void setLeaveApprovalOneTime(String leaveApprovalOneTime) {
		this.leaveApprovalOneTime = leaveApprovalOneTime;
	}

	public String getLeaveApprovalOneRemarks() {
		return leaveApprovalOneRemarks;
	}

	public void setLeaveApprovalOneRemarks(String leaveApprovalOneRemarks) {
		this.leaveApprovalOneRemarks = leaveApprovalOneRemarks;
	}


	public String getLeaveApprovalTwoTime() {
		return leaveApprovalTwoTime;
	}

	public void setLeaveApprovalTwoTime(String leaveApprovalTwoTime) {
		this.leaveApprovalTwoTime = leaveApprovalTwoTime;
	}

	public String getLeaveApprovalTwoRemarks() {
		return leaveApprovalTwoRemarks;
	}

	public void setLeaveApprovalTwoRemarks(String leaveApprovalTwoRemarks) {
		this.leaveApprovalTwoRemarks = leaveApprovalTwoRemarks;
	}


	public String getLeaveApprovalThreeTime() {
		return leaveApprovalThreeTime;
	}

	public void setLeaveApprovalThreeTime(String leaveApprovalThreeTime) {
		this.leaveApprovalThreeTime = leaveApprovalThreeTime;
	}

	public String getLeaveApprovalThreeRemarks() {
		return leaveApprovalThreeRemarks;
	}

	public void setLeaveApprovalThreeRemarks(String leaveApprovalThreeRemarks) {
		this.leaveApprovalThreeRemarks = leaveApprovalThreeRemarks;
	}
	
	public String getStudentSno() {
		return studentSno;
	}

	public void setStudentSno(String student) {
		this.studentSno = student;
	}

	public Integer getStudentLeaveId() {
		return studentLeaveId;
	}


	public void setStudentLeaveId(Integer studentLeaveId) {
		this.studentLeaveId = studentLeaveId;
	}


	public String getLeaveApprovalOne() {
		return leaveApprovalOne;
	}



	public void setLeaveApprovalOne(String leaveApprovalOne) {
		this.leaveApprovalOne = leaveApprovalOne;
	}



	public String getLeaveApprovalTwo() {
		return leaveApprovalTwo;
	}



	public void setLeaveApprovalTwo(String leaveApprovalTwo) {
		this.leaveApprovalTwo = leaveApprovalTwo;
	}



	public String getLeaveApprovalThree() {
		return leaveApprovalThree;
	}



	public String getSpecialty() {
		return specialty;
	}



	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}



	public String getFaculty() {
		return faculty;
	}



	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}



	public void setLeaveApprovalThree(String leaveApprovalThree) {
		this.leaveApprovalThree = leaveApprovalThree;
	}

	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	@Override
	public String toString() {
		return "\n学生请假信息 [编号=" + studentLeaveNum +", 学生="+ studentSno+", 班级名=" + className + ", 请假类型=" + leaveType
				+ ", 请假申请时间=" + leaveApplyTime + ", 请假理由=" + leaveReason + ", 请假证明=" + leaveProve
				+ ", 请假开始时间=" + leaveStartTime + ", 请假结束时间=" + leaveEndTime + ", 家长联系电话="
				+ parentPhone + ", 保证协议=" + leaveAgreement + ", 一级审批=" + leaveApprovalOne
				+ ", 一级审批时间=" + leaveApprovalOneTime + ", 一级审批备注="
				+ leaveApprovalOneRemarks + ", 二级审批=" + leaveApprovalTwo + ", 二级审批时间="
				+ leaveApprovalTwoTime + ", 二级审批备注=" + leaveApprovalTwoRemarks
				+ ", 三级审批=" + leaveApprovalThree + ", 三级审批时间=" + leaveApprovalThreeTime
				+ ", 三级审批备注=" + leaveApprovalThreeRemarks + "]\n";
	}



}
