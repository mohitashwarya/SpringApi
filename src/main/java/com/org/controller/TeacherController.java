package com.org.controller;

import com.org.dto.StudentVO;
import com.org.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/studentsUnderTeachers")
    public Map<String, List<StudentVO>> getStudentsUnderTeachers(){

        return teacherService.getStudentsUnderTeachers();
    }

    @GetMapping(value = "/suentsCountUnderTeacers")
    public Map<String, Integer> getStuentsCountUnderTeacers(){

        return teacherService.getStuentsCountUnderTeacers();
    }
}
