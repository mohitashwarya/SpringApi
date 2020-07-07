package com.org.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class TeacherVO {

    private String teacherCode;
    private String teacherName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate teacherDob;
    private boolean classTeacher;
    private double experience;
    private LocalDate passingYear;
    private List<SubjectVO> subjectTaughtByTeacher;
    private SchoolVO schoolId;
    private List<StudentVO> studentList;
    private QualificationVO qualification;
    private AddressVO address;

    public TeacherVO() {
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public LocalDate getTeacherDob() {
        return teacherDob;
    }

    public void setTeacherDob(LocalDate teacherDob) {
        this.teacherDob = teacherDob;
    }

    public boolean isClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(boolean classTeacher) {
        this.classTeacher = classTeacher;
    }

    public List<SubjectVO> getSubjectTaughtByTeacher() {
        return subjectTaughtByTeacher;
    }

    public void setSubjectTaughtByTeacher(List<SubjectVO> subjectTaughtByTeacher) {
        this.subjectTaughtByTeacher = subjectTaughtByTeacher;
    }

    public SchoolVO getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(SchoolVO schoolId) {
        this.schoolId = schoolId;
    }

    public List<StudentVO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentVO> studentList) {
        this.studentList = studentList;
    }

    public QualificationVO getQualification() {
        return qualification;
    }

    public void setQualification(QualificationVO qualification) {
        this.qualification = qualification;
    }

    public AddressVO getAddress() {
        return address;
    }

    public void setAddress(AddressVO address) {
        this.address = address;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public LocalDate getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(LocalDate passingYear) {
        this.passingYear = passingYear;
    }
}
