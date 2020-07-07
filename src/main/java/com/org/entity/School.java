package com.org.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School implements Serializable {

	private static final long serialVersionUID = 8558092075080304720L;
	
	@Id
    private String schoolCode;
    private String schoolName;
    private String schoolLocation;
    private String medium;
    private LocalDate schoolFormed;

    @OneToMany(mappedBy = "school")
    private List<Student> schoolStudentList = new ArrayList<>();

    @OneToMany(mappedBy = "schoolId")
    private List<Teacher> schoolTeacherList = new ArrayList<>();

    @OneToOne(optional = false, mappedBy = "school", fetch = FetchType.LAZY)
    private SchoolRegistration schoolReg;

    public School() {
    }

    public School(String schoolCode, String schoolName, String schoolLocation, String medium, LocalDate schoolFormed) {
        this.schoolCode = schoolCode;
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
        this.medium = medium;
        this.schoolFormed = schoolFormed;
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

    public List<Student> getSchoolStudentList() {
        return schoolStudentList;
    }

    public void setSchoolStudentList(Student schoolStudentList) {
        this.schoolStudentList.add(schoolStudentList);
    }

    public List<Teacher> getSchoolTeacherList() {
        return schoolTeacherList;
    }

    public void setSchoolStudentList(List<Student> schoolStudentList) {
        this.schoolStudentList = schoolStudentList;
    }

    public void setSchoolTeacherList(List<Teacher> schoolTeacherList) {
        this.schoolTeacherList = schoolTeacherList;
    }

    public void setSchoolTeacherList(Teacher schoolTeacherList) {
        this.schoolTeacherList.add(schoolTeacherList);
    }

    public SchoolRegistration getSchoolReg() {
        return schoolReg;
    }

    public void setSchoolReg(SchoolRegistration schoolReg) {
        this.schoolReg = schoolReg;
    }
}
