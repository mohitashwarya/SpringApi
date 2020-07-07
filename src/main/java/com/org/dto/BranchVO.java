package com.org.dto;

import java.util.List;

public class BranchVO {

    private String streamCode;
    private String streamDesc;
    private List<StudentVO> students;

    public BranchVO() {
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

    public List<StudentVO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentVO> students) {
        this.students = students;
    }
}
