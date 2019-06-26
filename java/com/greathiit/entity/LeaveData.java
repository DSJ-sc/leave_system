package com.greathiit.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class LeaveData {
	@Excel(name="请假日期",orderNum="1",width=15)
	private String leaveTime;
	/**当日请假总人数**/
	@Excel(name="请假数",orderNum="1",width=10)
	private Integer sumLeaveNum;
	/**事假人数**/
	@Excel(name="事假数",orderNum="1",width=10)
	private Integer personaLeaveNum;
	/**病假人数**/
	@Excel(name="病假数",orderNum="1",width=10)
	private Integer sickLeaveNum;
	/**晚假人数**/
	@Excel(name="晚假数",orderNum="1",width=10)
	private Integer nightLeaveNum;
	/**通过人数**/
	@Excel(name="通过数",orderNum="1",width=10)
	private Integer passNum;
	/**未通过人数**/
	@Excel(name="未通过数",orderNum="1",width=10)
	private Integer refuseNum;
	public LeaveData() {
		super();

	}
	public LeaveData(String leaveTime,  Integer sumLeaveNum,
			Integer personaLeaveNum, Integer sickLeaveNum, Integer nightLeaveNum, Integer passNum, Integer refuseNum) {
		super();
		this.leaveTime = leaveTime;
		this.sumLeaveNum = sumLeaveNum;
		this.personaLeaveNum = personaLeaveNum;
		this.sickLeaveNum = sickLeaveNum;
		this.nightLeaveNum = nightLeaveNum;
		this.passNum = passNum;
		this.refuseNum = refuseNum;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Integer getSumLeaveNum() {
		return sumLeaveNum;
	}
	public void setSumLeaveNum(Integer sumLeaveNum) {
		this.sumLeaveNum = sumLeaveNum;
	}
	public Integer getPersonaLeaveNum() {
		return personaLeaveNum;
	}
	public void setPersonaLeaveNum(Integer personaLeaveNum) {
		this.personaLeaveNum = personaLeaveNum;
	}
	public Integer getSickLeaveNum() {
		return sickLeaveNum;
	}
	public void setSickLeaveNum(Integer sickLeaveNum) {
		this.sickLeaveNum = sickLeaveNum;
	}
	public Integer getNightLeaveNum() {
		return nightLeaveNum;
	}
	public void setNightLeaveNum(Integer nightLeaveNum) {
		this.nightLeaveNum = nightLeaveNum;
	}
	public Integer getPassNum() {
		return passNum;
	}
	public void setPassNum(Integer passNum) {
		this.passNum = passNum;
	}
	public Integer getRefuseNum() {
		return refuseNum;
	}
	public void setRefuseNum(Integer refuseNum) {
		this.refuseNum = refuseNum;
	}
	@Override
	public String toString() {
		return "LeaveDate [leaveTime=" + leaveTime +", sumLeaveNum=" + sumLeaveNum + ", personaLeaveNum=" + personaLeaveNum
				+ ", sickLeaveNum=" + sickLeaveNum + ", nightLeaveNum=" + nightLeaveNum + ", passNum=" + passNum
				+ ", refuseNum=" + refuseNum + "]";
	}
	
}
