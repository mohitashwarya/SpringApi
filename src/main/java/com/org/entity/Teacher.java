package com.org.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher implements Serializable {

	private static final long serialVersionUID = 6340336678931366640L;
	
	@Id
    private String teacherCode;
    private String teacherName;
    private LocalDate teacherDob;
    private boolean classTeacher;
    private double experience;
    private LocalDate passingYear;

    @ManyToMany
    @JoinTable(name = "teacher_subject",
            joinColumns = { @JoinColumn(name = "teacherId") },
            inverseJoinColumns = { @JoinColumn(name = "subjectId") })
    private List<Subject> subjectTaughtByTeacher = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolTeacherFK")
    private School schoolId;

    @OneToMany
    @JoinColumn(name = "teacherFK")
    private List<Student> studentList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualificationFK")
    private Qualification qualification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressFK")
    private Address address;

    public Teacher() {
    }

    public Teacher(String teacherCode, String teacherName, LocalDate teacherDob, boolean classTeacher, double experience, LocalDate passingYear) {
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.teacherDob = teacherDob;
        this.classTeacher = classTeacher;
        this.experience = experience;
        this.passingYear = passingYear;
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

    public List<Subject> getSubjectTaughtByTeacher() {
        return subjectTaughtByTeacher;
    }

    public void setSubjectTaughtByTeacher(List<Subject> subjectTaughtByTeacher) {
        this.subjectTaughtByTeacher = subjectTaughtByTeacher;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Student studentList) {
        this.studentList.add(studentList);
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addSubjectTaughtByTeacher(Subject subjectTaughtByTeacher) {
        this.subjectTaughtByTeacher.add(subjectTaughtByTeacher);
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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

    @Override
    public String toString() {
        return teacherName+" --- " + studentList;
    }
}
