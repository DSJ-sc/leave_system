package com.greathiit.entity;

public class Specialty {
    /**
     * 专业id
     */
    private String specialtyId;

    /**
     * 专业名称
     */
    private String specialtyName;

    /**
     * 专业主任编号
     */
    private String specialtyTeacherNum;
    /**
     * 导员编号
     */
    private String guideTeacherNum;

    /**
     * 学院名称
     */
    private String facultyName;

    /**
     * 学院院长编号
     */
    private String facultyTeacherNum;

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId == null ? null : specialtyId.trim();
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName == null ? null : specialtyName.trim();
    }

    public String getSpecialtyTeacherNum() {
        return specialtyTeacherNum;
    }

    public void setSpecialtyTeacherNum(String specialtyTeacherNum) {
        this.specialtyTeacherNum = specialtyTeacherNum == null ? null : specialtyTeacherNum.trim();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName == null ? null : facultyName.trim();
    }

    public String getFacultyTeacherNum() {
        return facultyTeacherNum;
    }

    public void setFacultyTeacherNum(String facultyTeacherNum) {
        this.facultyTeacherNum = facultyTeacherNum == null ? null : facultyTeacherNum.trim();
    }

	public String getGuideTeacherNum() {
		return guideTeacherNum;
	}

	public void setGuideTeacherNum(String guideTeacherNum) {
		this.guideTeacherNum = guideTeacherNum;
	}
}