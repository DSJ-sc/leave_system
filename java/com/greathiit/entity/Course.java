package com.greathiit.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-01-20
 */
public class Course {
    /**
     * 课程id
     */
    private String courseId;

    /**
     * 课程名
     */
    private String courseName;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }
}