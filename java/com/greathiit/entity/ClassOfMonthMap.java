package com.greathiit.entity;

public class ClassOfMonthMap extends ClassMap{
  private int[] thingNum = new int[31];
  private int[] sickNum = new int[31];
  private int[] nightNum = new int[31];
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
