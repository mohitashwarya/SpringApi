package com.org.util;

import com.org.dto.*;
import com.org.entity.*;

import java.util.stream.Collectors;

public class Utility {

    public static SchoolVO toSchoolVO(School school){

        SchoolVO schoolVO = new SchoolVO();
        schoolVO.setSchoolCode(school.getSchoolCode());
        schoolVO.setMedium(school.getMedium());
        schoolVO.setSchoolFormed(school.getSchoolFormed());
        schoolVO.setSchoolLocation(school.getSchoolLocation());
        schoolVO.setSchoolName(school.getSchoolName());

        schoolVO.setSchoolReg(toSchoolRegistrationVO(school.getSchoolReg()));

        schoolVO.setSchoolStudentList(school.getSchoolStudentList().stream()
                .map(student -> toStudentVO(student)).collect(Collectors.toList()));

        schoolVO.setSchoolTeacherList(school.getSchoolTeacherList().stream()
                .map(Utility::toTeacherVO).collect(Collectors.toList()));



        return schoolVO;
    }

    public static StudentVO toStudentVO(Student student){

        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName(student.getStudentName());
        studentVO.setStudentCode(student.getStudentCode());
        studentVO.setStudentGender(student.getStudentGender());
        studentVO.setStudentDob(student.getStudentDob());

        return studentVO;
    }

    public static TeacherVO toTeacherVO(Teacher teacher){

        TeacherVO teacherVO = new TeacherVO();
        teacherVO.setTeacherCode(teacher.getTeacherCode());
        teacherVO.setTeacherName(teacher.getTeacherName());
        teacherVO.setClassTeacher(teacher.isClassTeacher());
        teacherVO.setTeacherDob(teacher.getTeacherDob());
        teacherVO.setExperience(teacher.getExperience());
        teacherVO.setPassingYear(teacher.getPassingYear());

        if(teacher.getQualification() != null){
            teacherVO.setQualification(toQualificationVO(teacher.getQualification()));
        }
        if(!teacher.getSubjectTaughtByTeacher().isEmpty()){
            System.out.println("--------------------------------------------------------------------------");
            teacherVO.setSubjectTaughtByTeacher(teacher.getSubjectTaughtByTeacher()
                            .stream().map(subject -> toSubjectVO(subject))
                            .collect(Collectors.toList()));
        }

        return teacherVO;
    }

    public static BranchVO toBranchVO(Branch branch){

        return null;
    }

    public static SchoolRegistrationVO toSchoolRegistrationVO(SchoolRegistration schoolRegistration){

        SchoolRegistrationVO schoolRegistrationVO = new SchoolRegistrationVO();

        schoolRegistrationVO.setRegistrationNo(schoolRegistration.getRegistrationNo());
        schoolRegistrationVO.setFounderName(schoolRegistration.getFounderName());
        schoolRegistrationVO.setAffiliatonClass(schoolRegistration.getAffiliatonClass());
        schoolRegistrationVO.setCountry(schoolRegistration.getCountry());
        schoolRegistrationVO.setSchoolInCity(schoolRegistration.getSchoolInCity());
        schoolRegistrationVO.setSchoolInState(schoolRegistration.getSchoolInState());
        schoolRegistrationVO.setPinCode(schoolRegistration.getPinCode());

        return schoolRegistrationVO;
    }

    public static AddressVO toAddressVO(Address address){

        return  null;
    }

    public static QualificationVO toQualificationVO(Qualification qualification){
        QualificationVO qualificationVO = new QualificationVO();
        qualificationVO.setId(qualification.getId());
        qualificationVO.setDegree(qualification.getDegree());

        return qualificationVO;
    }

    public static SubjectVO toSubjectVO(Subject subject){

        SubjectVO subjectVO = new SubjectVO();
        subjectVO.setSubjectCode(subject.getSubjectCode());
        subjectVO.setSubjectName(subject.getSubjectName());
        subjectVO.setOptionalSubject(subject.isOptionalSubject());

        return subjectVO;
    }

}
