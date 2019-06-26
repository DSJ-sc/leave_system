package com.greathiit.entity;
/**
 * 教师调课统计类
 * */
public class TeacherMap {
	 /**
	   * 软件学院
	   * */
  private int[] softwareCollege = new int[12];
	  /**
	   * 商学院
	   * */
  private int[] businessCollege = new int[12];
	  /**
	   * 电子工程学院
	   * */
  private int[] electronicEngineeringCollege = new int[12];
	  /**
	   * 艺术设计学院
	   * */
  private int[] artDesignCollege = new int[12];
	public int[] getSoftwareCollege() {
		return softwareCollege;
	}
	public void setSoftwareCollege(int[] softwareCollege) {
		this.softwareCollege = softwareCollege;
	}
	public int[] getBusinessCollege() {
		return businessCollege;
	}
	public void setBusinessCollege(int[] businessCollege) {
		this.businessCollege = businessCollege;
	}
	public int[] getElectronicEngineeringCollege() {
		return electronicEngineeringCollege;
	}
	public void setElectronicEngineeringCollege(int[] electronicEngineeringCollege) {
		this.electronicEngineeringCollege = electronicEngineeringCollege;
	}
	public int[] getArtDesignCollege() {
		return artDesignCollege;
	}
	public void setArtDesignCollege(int[] artDesignCollege) {
		this.artDesignCollege = artDesignCollege;
	}
  
}
