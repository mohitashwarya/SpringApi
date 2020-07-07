package com.org.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch implements Serializable {

	private static final long serialVersionUID = -2260805810812343343L;
	
	@Id
    private String streamCode;
    private String streamDesc;

    @OneToMany
    @JoinColumn(name = "branchFK")
    private List<Student> students = new ArrayList<>();

    public Branch() {
    }

    public Branch(String streamCode, String streamDesc) {
        this.streamCode = streamCode;
        this.streamDesc = streamDesc;
    }

    public String getStreamCode() {
        return streamCode;
    }

    public void setStreamCode(String streamCode) {
        this.streamCode = streamCode;
    }

    public String getStreamDesc() {
        return streamDesc;
    }

    public void setStreamDesc(String streamDesc) {
        this.streamDesc = streamDesc;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudents(Student students) {
        this.students.add(students);
    }
}
