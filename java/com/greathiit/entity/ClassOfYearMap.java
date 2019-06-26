package com.greathiit.entity;

public class ClassOfYearMap extends ClassMap{
	private int[] thingNum = new int[12];
	private int[] sickNum = new int[12];
	private int[] nightNum = new int[12];
	@Override
	public int[] getThingNum() {
		return thingNum;
	}
	@Override
	public void setThingNum(int[] thingNum) {
		this.thingNum = thingNum;
	}
	@Override
	public int[] getSickNum() {
		return sickNum;
	}
	@Override
	public void setSickNum(int[] sickNum) {
		this.sickNum = sickNum;
	}
	@Override
	public int[] getNightNum() {
		return nightNum;
	}
	@Override
	public void setNightNum(int[] nightNum) {
		this.nightNum = nightNum;
	}
	  
}
