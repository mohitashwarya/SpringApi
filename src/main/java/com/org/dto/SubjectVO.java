package com.org.dto;

import java.util.List;

public class SubjectVO {

    private String subjectCode;
    private String SubjectName;
    private boolean optionalSubject;
    private List<TeacherVO> teacherTeachingSubject;

    public SubjectVO() {
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public boolean isOptionalSubject() {
        return optionalSubject;
    }

    public void setOptionalSubject(boolean optionalSubject) {
        this.optionalSubject = optionalSubject;
    }

    public List<TeacherVO> getTeacherTeachingSubject() {
        return teacherTeachingSubject;
    }

    public void setTeacherTeachingSubject(List<TeacherVO> teacherTeachingSubject) {
        this.teacherTeachingSubject = teacherTeachingSubject;
    }
}
