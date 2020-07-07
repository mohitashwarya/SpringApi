package com.org.mapper;

import com.org.dto.AddressVO;
import com.org.dto.BranchVO;
import com.org.dto.QualificationVO;
import com.org.dto.SchoolRegistrationVO;
import com.org.dto.SchoolVO;
import com.org.dto.StudentVO;
import com.org.dto.SubjectVO;
import com.org.dto.TeacherVO;
import com.org.entity.Address;
import com.org.entity.Branch;
import com.org.entity.Qualification;
import com.org.entity.School;
import com.org.entity.SchoolRegistration;
import com.org.entity.Student;
import com.org.entity.Subject;
import com.org.entity.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-06T15:20:09+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.21.0.v20200304-1404, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class CustomMapperImpl implements CustomMapper {

    @Override
    public BranchVO toBranchVO(Branch branch) {
        if ( branch == null ) {
            return null;
        }

        BranchVO branchVO = new BranchVO();

        branchVO.setStreamCode( branch.getStreamCode() );
        branchVO.setStreamDesc( branch.getStreamDesc() );
        branchVO.setStudents( toListStudentVO( branch.getStudents() ) );

        return branchVO;
    }

    @Override
    public List<BranchVO> toListBranchVO(List<Branch> branches) {
        if ( branches == null ) {
            return null;
        }

        List<BranchVO> list = new ArrayList<BranchVO>( branches.size() );
        for ( Branch branch : branches ) {
            list.add( toBranchVO( branch ) );
        }

        return list;
    }

    @Override
    public StudentVO toStudentVO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentVO studentVO = new StudentVO();

        studentVO.setStudentCode( student.getStudentCode() );
        studentVO.setStudentName( student.getStudentName() );
        studentVO.setStudentDob( student.getStudentDob() );
        studentVO.setStudentGender( student.getStudentGender() );
        studentVO.setSchool( toSchoolVO( student.getSchool() ) );
        studentVO.setAddress( toAddressVO( student.getAddress() ) );

        return studentVO;
    }

    @Override
    public List<StudentVO> toListStudentVO(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentVO> list = new ArrayList<StudentVO>( students.size() );
        for ( Student student : students ) {
            list.add( toStudentVO( student ) );
        }

        return list;
    }

    @Override
    public TeacherVO toTeacherVO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherVO teacherVO = new TeacherVO();

        teacherVO.setTeacherCode( teacher.getTeacherCode() );
        teacherVO.setTeacherName( teacher.getTeacherName() );
        teacherVO.setTeacherDob( teacher.getTeacherDob() );
        teacherVO.setClassTeacher( teacher.isClassTeacher() );
        teacherVO.setSubjectTaughtByTeacher( toListSubjectVO( teacher.getSubjectTaughtByTeacher() ) );
        teacherVO.setSchoolId( toSchoolVO( teacher.getSchoolId() ) );
        teacherVO.setStudentList( toListStudentVO( teacher.getStudentList() ) );
        teacherVO.setQualification( toQualificationVO( teacher.getQualification() ) );
        teacherVO.setAddress( toAddressVO( teacher.getAddress() ) );
        teacherVO.setExperience( teacher.getExperience() );
        teacherVO.setPassingYear( teacher.getPassingYear() );

        return teacherVO;
    }

    @Override
    public List<TeacherVO> toListTeacherVO(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherVO> list = new ArrayList<TeacherVO>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( toTeacherVO( teacher ) );
        }

        return list;
    }

    @Override
    public AddressVO toAddressVO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressVO addressVO = new AddressVO();

        addressVO.setAreaPin( address.getAreaPin() );
        addressVO.setAreaName( address.getAreaName() );
        addressVO.setPoliceStation( address.getPoliceStation() );

        return addressVO;
    }

    @Override
    public List<AddressVO> toListAddressVO(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressVO> list = new ArrayList<AddressVO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toAddressVO( address ) );
        }

        return list;
    }

    @Override
    public SchoolVO toSchoolVO(School school) {
        if ( school == null ) {
            return null;
        }

        SchoolVO schoolVO = new SchoolVO();

        schoolVO.setSchoolCode( school.getSchoolCode() );
        schoolVO.setSchoolName( school.getSchoolName() );
        schoolVO.setSchoolLocation( school.getSchoolLocation() );
        schoolVO.setMedium( school.getMedium() );
        schoolVO.setSchoolFormed( school.getSchoolFormed() );
        schoolVO.setSchoolStudentList( toListStudentVO( school.getSchoolStudentList() ) );
        schoolVO.setSchoolTeacherList( toListTeacherVO( school.getSchoolTeacherList() ) );
        schoolVO.setSchoolReg( toSchoolRegistrationVO( school.getSchoolReg() ) );

        return schoolVO;
    }

    @Override
    public List<SchoolVO> toListSchoolVO(List<School> schools) {
        if ( schools == null ) {
            return null;
        }

        List<SchoolVO> list = new ArrayList<SchoolVO>( schools.size() );
        for ( School school : schools ) {
            list.add( toSchoolVO( school ) );
        }

        return list;
    }

    @Override
    public SchoolRegistrationVO toSchoolRegistrationVO(SchoolRegistration schoolRegistration) {
        if ( schoolRegistration == null ) {
            return null;
        }

        SchoolRegistrationVO schoolRegistrationVO = new SchoolRegistrationVO();

        schoolRegistrationVO.setRegistrationNo( schoolRegistration.getRegistrationNo() );
        schoolRegistrationVO.setAffiliatonClass( schoolRegistration.getAffiliatonClass() );
        schoolRegistrationVO.setFounderName( schoolRegistration.getFounderName() );
        schoolRegistrationVO.setSchoolInCity( schoolRegistration.getSchoolInCity() );
        schoolRegistrationVO.setSchoolInState( schoolRegistration.getSchoolInState() );
        schoolRegistrationVO.setCountry( schoolRegistration.getCountry() );
        schoolRegistrationVO.setPinCode( schoolRegistration.getPinCode() );
        schoolRegistrationVO.setSchool( toSchoolVO( schoolRegistration.getSchool() ) );

        return schoolRegistrationVO;
    }

    @Override
    public List<SchoolRegistrationVO> toListSchoolRegistrationVO(List<SchoolRegistration> schoolRegistrations) {
        if ( schoolRegistrations == null ) {
            return null;
        }

        List<SchoolRegistrationVO> list = new ArrayList<SchoolRegistrationVO>( schoolRegistrations.size() );
        for ( SchoolRegistration schoolRegistration : schoolRegistrations ) {
            list.add( toSchoolRegistrationVO( schoolRegistration ) );
        }

        return list;
    }

    @Override
    public SubjectVO toSubjectVO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectVO subjectVO = new SubjectVO();

        subjectVO.setSubjectCode( subject.getSubjectCode() );
        subjectVO.setSubjectName( subject.getSubjectName() );
        subjectVO.setOptionalSubject( subject.isOptionalSubject() );
        subjectVO.setTeacherTeachingSubject( toListTeacherVO( subject.getTeacherTeachingSubject() ) );

        return subjectVO;
    }

    @Override
    public List<SubjectVO> toListSubjectVO(List<Subject> subjects) {
        if ( subjects == null ) {
            return null;
        }

        List<SubjectVO> list = new ArrayList<SubjectVO>( subjects.size() );
        for ( Subject subject : subjects ) {
            list.add( toSubjectVO( subject ) );
        }

        return list;
    }

    @Override
    public QualificationVO toQualificationVO(Qualification qualification) {
        if ( qualification == null ) {
            return null;
        }

        QualificationVO qualificationVO = new QualificationVO();

        qualificationVO.setId( qualification.getId() );
        qualificationVO.setDegree( qualification.getDegree() );

        return qualificationVO;
    }

    @Override
    public List<QualificationVO> toListQualificationVO(List<Qualification> qualifications) {
        if ( qualifications == null ) {
            return null;
        }

        List<QualificationVO> list = new ArrayList<QualificationVO>( qualifications.size() );
        for ( Qualification qualification : qualifications ) {
            list.add( toQualificationVO( qualification ) );
        }

        return list;
    }
}
