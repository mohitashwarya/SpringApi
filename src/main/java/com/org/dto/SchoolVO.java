package com.org.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class SchoolVO {

    private String schoolCode;
    private String schoolName;
    private String schoolLocation;
    private String medium;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate schoolFormed;
    private List<StudentVO> schoolStudentList;
    private List<TeacherVO> schoolTeacherList;
    private SchoolRegistrationVO schoolReg;

    public SchoolVO() {
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public LocalDate getSchoolFormed() {
        return schoolFormed;
    }

    public void setSchoolFormed(LocalDate schoolFormed) {
        this.schoolFormed = schoolFormed;
    }

    public List<StudentVO> getSchoolStudentList() {
        return schoolStudentList;
    }

    public void setSchoolStudentList(List<StudentVO> schoolStudentList) {
        this.schoolStudentList = schoolStudentList;
    }

    public List<TeacherVO> getSchoolTeacherList() {
        return schoolTeacherList;
    }

    public void setSchoolTeacherList(List<TeacherVO> schoolTeacherList) {
        this.schoolTeacherList = schoolTeacherList;
    }

    public SchoolRegistrationVO getSchoolReg() {
        return schoolReg;
    }

    public void setSchoolReg(SchoolRegistrationVO schoolReg) {
        this.schoolReg = schoolReg;
    }
}
