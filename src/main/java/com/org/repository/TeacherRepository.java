package com.org.repository;

import com.org.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {

    public Optional<List<Teacher>> getStudentsUnderTeachers();

    public List<Object[]> getStuentsCountUnderTeacers();
}
