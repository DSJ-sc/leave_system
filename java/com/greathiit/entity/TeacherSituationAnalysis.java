package com.greathiit.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * @author 邓世江
 * @date 2018年11月18日 下午3:11:12
 * 
 */
@ExcelTarget("TeacherSituationAnalysis")
public class TeacherSituationAnalysis {
	/**专业**/
	@Excel(name="专业",orderNum="1",width=15,needMerge = true)
	private String specialtyName;
	/**职工号**/
	@Excel(name="职工号",orderNum="1",width=15,needMerge = true)
	private String teacherNum;
	/**姓名**/
	@Excel(name="姓名",orderNum="1",width=15,needMerge = true)
	private String teacherName;
	/**请假日期**/
	@Excel(name="请假日期",orderNum="1",width=15,needMerge = true)
	
	private String leaveTime;
	@Excel(name="请假类型",orderNum="1",width=15,needMerge = true)
	private String leaveType;
	
	@Excel(name="请假理由",orderNum="1",width=15,needMerge = true)
	private String leaveReason;
	/**学院*/
	private String facultyName;
	private Integer leaveNum;
	public TeacherSituationAnalysis() {

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
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public Integer getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(Integer leaveNum) {
		this.leaveNum = leaveNum;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	
	
}
