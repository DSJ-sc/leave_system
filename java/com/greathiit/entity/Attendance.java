package com.greathiit.entity;

import java.util.Date;

public class Attendance {
    /**
     * 出勤id
     */
    private Integer attendanceId;

    /**
     * 出勤编号课程号+学号+时间
     */
    private String attendanceNum;

    /**
     * 学生学号
     */
    private String attendanceSno;

    /**
     * 学生姓名
     */
    private String attendanceName;

    /**
     * 课程名
     */
    private String attendanceCourse;

    /**
     * 班级名
     */
    private String attendanceClass;

    /**
     * 教师编号
     */
    private String attendanceTeacher;

    /**
     * 出勤状态
     */
    private String attendanceState;

    /**
     * 签到时间
     */
    private Date attendanceIn;

    /**
     * 签退时间
     */
    private Date attendanceOut;

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getAttendanceNum() {
        return attendanceNum;
    }

    public void setAttendanceNum(String attendanceNum) {
        this.attendanceNum = attendanceNum == null ? null : attendanceNum.trim();
    }

    public String getAttendanceSno() {
        return attendanceSno;
    }

    public void setAttendanceSno(String attendanceSno) {
        this.attendanceSno = attendanceSno == null ? null : attendanceSno.trim();
    }

    public String getAttendanceName() {
        return attendanceName;
    }

    public void setAttendanceName(String attendanceName) {
        this.attendanceName = attendanceName == null ? null : attendanceName.trim();
    }

    public String getAttendanceCourse() {
        return attendanceCourse;
    }

    public void setAttendanceCourse(String attendanceCourse) {
        this.attendanceCourse = attendanceCourse == null ? null : attendanceCourse.trim();
    }

    public String getAttendanceClass() {
        return attendanceClass;
    }

    public void setAttendanceClass(String attendanceClass) {
        this.attendanceClass = attendanceClass == null ? null : attendanceClass.trim();
    }

    public String getAttendanceTeacher() {
        return attendanceTeacher;
    }

    public void setAttendanceTeacher(String attendanceTeacher) {
        this.attendanceTeacher = attendanceTeacher == null ? null : attendanceTeacher.trim();
    }

    public String getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState == null ? null : attendanceState.trim();
    }

    public Date getAttendanceIn() {
        return attendanceIn;
    }

    public void setAttendanceIn(Date attendanceIn) {
        this.attendanceIn = attendanceIn;
    }

    public Date getAttendanceOut() {
        return attendanceOut;
    }

    public void setAttendanceOut(Date attendanceOut) {
        this.attendanceOut = attendanceOut;
    }
}