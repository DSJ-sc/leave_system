package com.greathiit.entity;

import java.util.List;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * @author 邓世江
 * @date 2018年11月13日 下午3:13:13
 * 
 */
@ExcelTarget("StudentSituationAnalysis")
public class StudentSituationAnalysis {
	private String className;
	/**学号**/
	@Excel(name="学号",orderNum="1",width=15,needMerge = true)
	private String studentSno;
	/**姓名**/
	@Excel(name="姓名",orderNum="1",width=15,needMerge = true)
	private String studentName;
	/**性别**/
	@Excel(name="性别",orderNum="1",width=15,needMerge = true)
	private String studentSex;
	/**请假信息**/
	@ExcelCollection(name="请假信息",orderNum="7")
	private List<LeaveData> leaveData;
	public StudentSituationAnalysis() {
		super();
	}
	public StudentSituationAnalysis(String studentSno, String studentName, String studentSex,
			List<LeaveData> leaveData) {
		super();
		this.studentSno = studentSno;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.leaveData = leaveData;
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
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public List<LeaveData> getLeaveData() {
		return leaveData;
	}
	public void setLeaveData(List<LeaveData> leaveData) {
		this.leaveData = leaveData;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "StudentSituationAnalysis [studentSno=" + studentSno + ", studentName=" + studentName + ", studentSex="
				+ studentSex + ", leaveData=" + leaveData + "]";
	}
	
	
}
	