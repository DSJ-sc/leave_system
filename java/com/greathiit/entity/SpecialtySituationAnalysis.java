package com.greathiit.entity;

import java.util.List;

import cn.afterturn.easypoi.excel.annotation.ExcelCollection;

public class SpecialtySituationAnalysis {
	public String specialtyName;
	@ExcelCollection(orderNum="7", name = "")
	private List<LeaveData> leaveData;
	public SpecialtySituationAnalysis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SpecialtySituationAnalysis(String specialtyName, List<LeaveData> leaveData) {
		super();
		this.specialtyName = specialtyName;
		this.leaveData = leaveData;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public List<LeaveData> getLeaveData() {
		return leaveData;
	}
	public void setLeaveData(List<LeaveData> leaveData) {
		this.leaveData = leaveData;
	}
	@Override
	public String toString() {
		return "SpecialtySituationAnalysis [specialtyName=" + specialtyName + ", leaveData=" + leaveData + "]";
	}
	
}
