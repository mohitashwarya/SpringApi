package com.org.service;

import com.org.dto.StudentVO;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    public Map<String, List<StudentVO>> getStudentsUnderTeachers();

    public Map<String, Integer> getStuentsCountUnderTeacers();
}
