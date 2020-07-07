package com.org.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject implements Serializable {

	private static final long serialVersionUID = -8546424264724089847L;
	
	@Id
    private String subjectCode;
    private String SubjectName;
    private boolean optionalSubject;

    @ManyToMany(mappedBy = "subjectTaughtByTeacher")
    private List<Teacher> teacherTeachingSubject = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subjectCode, String subjectName, boolean optionalSubject) {
        this.subjectCode = subjectCode;
        SubjectName = subjectName;
        this.optionalSubject = optionalSubject;
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

    public List<Teacher> getTeacherTeachingSubject() {
        return teacherTeachingSubject;
    }

    public void setTeacherTeachingSubject(Teacher teacherTeachingSubject) {
        this.teacherTeachingSubject.add(teacherTeachingSubject);
    }

    public void setTeacherTeachingSubject(List<Teacher> teacherTeachingSubject) {
        this.teacherTeachingSubject = teacherTeachingSubject;
    }
}
