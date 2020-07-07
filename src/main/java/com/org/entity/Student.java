package com.org.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    private String studentCode;
    private String studentName;
    private LocalDate studentDob;
    private char studentGender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolFK")
    private School school;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressFK")
    private Address address;

    public Student() {
    }

    public Student(String studentCode, String studentName, LocalDate studentDob, char studentGender) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.studentGender = studentGender;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(LocalDate studentDob) {
        this.studentDob = studentDob;
    }

    public char getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(char studentGender) {
        this.studentGender = studentGender;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return studentName;
    }
}
