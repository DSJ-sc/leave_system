package com.greathiit.entity;

public class TeacherLeaveInfo {
    /**
     * id编号
     */
    private Integer teacherLeaveId;

    /**
     * 教师请假编号
     */
    private String teacherLeaveNum;
    /**
     * 教师编号
     */
    private String teacherNum;
    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 所属专业
     */
    private String teacherSpecialty;
    /**
     * 所属学院
     */
    private String teacherFaculty;

    /**
     * 申请时间
     */
    private String leaveApplyTime;

    /**
     * 授课班级
     */
    private String className;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 调整前校历周数
     */
    private Integer oldSchoolweek;

    /**
     * 调整前上课日期
     */
    private String oldDay;

    /**
     * 调整前上课星期
     */
    private String oldWeek;

    /**
     * 调整前上课节数
     */
    private String oldTime;

    /**
     * 调整前教室
     */
    private String oldClassRoom;

    /**
     * 调整后校历周数
     */
    private Integer newSchoolweek;

    /**
     * 调整后上课日期
     */
    private String newDay;

    /**
     * 调整后上课星期
     */
    private String newWeek;

    /**
     * 调整后上课节数
     */
    private String newTime;

    /**
     * 调整后教室
     */
    private String newClassRoom;

    /**
     * 调课类型
     */
    private String leaveType;

    /**
     * 替课教师
     */
    private String replaceTeacher;

    /**
     * 调课理由 因公因私
     */
    private String leaveReason;

    /**
     * 具体理由
     */
    private String specificReason;

    /**
     * 院系审批
     */
    private String leaveApprovalOne;

    /**
     * 院系审批时间
     */
    private String leaveApprovalOneTime;

    /**
     * 教务处审批
     */
    private String leaveApprovalTwo;

    /**
     * 教务处审批时间
     */
    private String leaveApprovalTwoTime;

    public Integer getTeacherLeaveId() {
        return teacherLeaveId;
    }

    public void setTeacherLeaveId(Integer teacherLeaveId) {
        this.teacherLeaveId = teacherLeaveId;
    }

    public String getTeacherLeaveNum() {
        return teacherLeaveNum;
    }

    public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public void setTeacherLeaveNum(String teacherLeaveNum) {
        this.teacherLeaveNum = teacherLeaveNum == null ? null : teacherLeaveNum.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSpecialty() {
        return teacherSpecialty;
    }

    public void setTeacherSpecialty(String teacherSpecialty) {
        this.teacherSpecialty = teacherSpecialty == null ? null : teacherSpecialty.trim();
    }

    public String getLeaveApplyTime() {
        return leaveApplyTime;
    }

    public void setLeaveApplyTime(String leaveApplyTime) {
        this.leaveApplyTime = leaveApplyTime == null ? null : leaveApplyTime.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getOldSchoolweek() {
        return oldSchoolweek;
    }

    public void setOldSchoolweek(Integer oldSchoolweek) {
        this.oldSchoolweek = oldSchoolweek;
    }

    public String getOldDay() {
        return oldDay;
    }

    public void setOldDay(String oldDay) {
        this.oldDay = oldDay == null ? null : oldDay.trim();
    }

    public String getOldWeek() {
        return oldWeek;
    }

    public void setOldWeek(String oldWeek) {
        this.oldWeek = oldWeek == null ? null : oldWeek.trim();
    }

    public String getOldTime() {
        return oldTime;
    }

    public void setOldTime(String oldTime) {
        this.oldTime = oldTime == null ? null : oldTime.trim();
    }

    public String getOldClassRoom() {
        return oldClassRoom;
    }

    public void setOldClassRoom(String oldClassRoom) {
        this.oldClassRoom = oldClassRoom == null ? null : oldClassRoom.trim();
    }

    public Integer getNewSchoolweek() {
        return newSchoolweek;
    }

    public void setNewSchoolweek(Integer newSchoolweek) {
        this.newSchoolweek = newSchoolweek;
    }

    public String getNewDay() {
        return newDay;
    }

    public void setNewDay(String newDay) {
        this.newDay = newDay == null ? null : newDay.trim();
    }

    public String getNewWeek() {
        return newWeek;
    }

    public void setNewWeek(String newWeek) {
        this.newWeek = newWeek == null ? null : newWeek.trim();
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime == null ? null : newTime.trim();
    }

    public String getNewClassRoom() {
        return newClassRoom;
    }

    public void setNewClassRoom(String newClassRoom) {
        this.newClassRoom = newClassRoom == null ? null : newClassRoom.trim();
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    public String getReplaceTeacher() {
        return replaceTeacher;
    }

    public void setReplaceTeacher(String replaceTeacher) {
        this.replaceTeacher = replaceTeacher == null ? null : replaceTeacher.trim();
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }

    public String getSpecificReason() {
        return specificReason;
    }

    public void setSpecificReason(String specificReason) {
        this.specificReason = specificReason == null ? null : specificReason.trim();
    }

    public String getLeaveApprovalOne() {
        return leaveApprovalOne;
    }

    public void setLeaveApprovalOne(String leaveApprovalOne) {
        this.leaveApprovalOne = leaveApprovalOne == null ? null : leaveApprovalOne.trim();
    }

    public String getLeaveApprovalOneTime() {
        return leaveApprovalOneTime;
    }

    public void setLeaveApprovalOneTime(String leaveApprovalOneTime) {
        this.leaveApprovalOneTime = leaveApprovalOneTime == null ? null : leaveApprovalOneTime.trim();
    }

    public String getLeaveApprovalTwo() {
        return leaveApprovalTwo;
    }

    public void setLeaveApprovalTwo(String leaveApprovalTwo) {
        this.leaveApprovalTwo = leaveApprovalTwo == null ? null : leaveApprovalTwo.trim();
    }

    public String getLeaveApprovalTwoTime() {
        return leaveApprovalTwoTime;
    }

    public void setLeaveApprovalTwoTime(String leaveApprovalTwoTime) {
        this.leaveApprovalTwoTime = leaveApprovalTwoTime == null ? null : leaveApprovalTwoTime.trim();
    }

	public String getTeacherFaculty() {
		return teacherFaculty;
	}

	public void setTeacherFaculty(String teacherFaculty) {
		this.teacherFaculty = teacherFaculty == null ? null : teacherFaculty.trim();
	}
    
}