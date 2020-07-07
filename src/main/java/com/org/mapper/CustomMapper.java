package com.org.mapper;

import com.org.dto.*;
import com.org.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomMapper {

    BranchVO toBranchVO(Branch branch);
    List<BranchVO> toListBranchVO(List<Branch> branches);

    StudentVO toStudentVO(Student student);
    List<StudentVO> toListStudentVO(List<Student> students);

    TeacherVO toTeacherVO(Teacher teacher);
    List<TeacherVO> toListTeacherVO(List<Teacher> teachers);

    AddressVO toAddressVO(Address address);
    List<AddressVO> toListAddressVO(List<Address> addresses);

    SchoolVO toSchoolVO(School school);
    List<SchoolVO> toListSchoolVO(List<School> schools);

    SchoolRegistrationVO toSchoolRegistrationVO(SchoolRegistration schoolRegistration);
    List<SchoolRegistrationVO> toListSchoolRegistrationVO(List<SchoolRegistration> schoolRegistrations);

    SubjectVO toSubjectVO(Subject subject);
    List<SubjectVO> toListSubjectVO(List<Subject> subjects);

    QualificationVO toQualificationVO(Qualification qualification);
    List<QualificationVO> toListQualificationVO(List<Qualification> qualifications);
}
