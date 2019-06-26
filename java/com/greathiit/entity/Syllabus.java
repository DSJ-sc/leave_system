package com.greathiit.entity;

public class Syllabus {
    /**
     * 授课主键
     */
    private String teachId;

    /**
     * 授课教师id
     */
    private String teachTeacherId;

    /**
     * 授课课程id
     */
    private String teachCourse;

    /**
     * 上课班级
     */
    private String teachClass;

    /**
     * 课程开始时间
     */
    private String teachStartTime;

    /**
     * 课程结束时间
     */
    private String teachEndTime;

    /**
     * 课程在星期几
     */
    private String teachWeekTime;

    /**
     * 课程在第几节课
     */
    private String teachDayTime;

    /**
     * 课程所在教室
     */
    private String teachClassroom;

    public String getTeachId() {
        return teachId;
    }

    public void setTeachId(String teachId) {
        this.teachId = teachId;
    }

    public String getTeachTeacherId() {
        return teachTeacherId;
    }

    public void setTeachTeacherId(String teachTeacherId) {
        this.teachTeacherId = teachTeacherId == null ? null : teachTeacherId.trim();
    }

    public String getTeachCourse() {
        return teachCourse;
    }

    public void setTeachCourse(String teachCourse) {
        this.teachCourse = teachCourse;
    }

    public String getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(String teachClass) {
        this.teachClass = teachClass == null ? null : teachClass.trim();
    }

    public String getTeachStartTime() {
        return teachStartTime;
    }

    public void setTeachStartTime(String teachStartTime) {
        this.teachStartTime = teachStartTime;
    }

    public String getTeachEndTime() {
        return teachEndTime;
    }

    public void setTeachEndTime(String teachEndTime) {
        this.teachEndTime = teachEndTime;
    }

    public String getTeachWeekTime() {
        return teachWeekTime;
    }

    public void setTeachWeekTime(String teachWeekTime) {
        this.teachWeekTime = teachWeekTime == null ? null : teachWeekTime.trim();
    }

    public String getTeachDayTime() {
        return teachDayTime;
    }

    public void setTeachDayTime(String teachDayTime) {
        this.teachDayTime = teachDayTime == null ? null : teachDayTime.trim();
    }

    public String getTeachClassroom() {
        return teachClassroom;
    }

    public void setTeachClassroom(String teachClassroom) {
        this.teachClassroom = teachClassroom == null ? null : teachClassroom.trim();
    }

	@Override
	public String toString() {
		return "Syllabus [teachId=" + teachId + ", teachTeacherId=" + teachTeacherId + ", teachCourse=" + teachCourse
				+ ", teachClass=" + teachClass + ", teachStartTime=" + teachStartTime + ", teachEndTime=" + teachEndTime
				+ ", teachWeekTime=" + teachWeekTime + ", teachDayTime=" + teachDayTime + ", teachClassroom="
				+ teachClassroom + "]";
	}
    
}