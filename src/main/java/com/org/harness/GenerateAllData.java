package com.org.harness;

import com.org.entity.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class GenerateAllData {

    @PersistenceContext
    private EntityManager entityManager;

    public void genereateData(){

        School school = new School("DALIMSS","Dr Amrit Lal Ishrat Memorial Sunbeam School","Lahurabir","English", LocalDate.of(1990,7,26));

        SchoolRegistration schoolReg = new SchoolRegistration("DAL-1990",12,"Baba Madhok","Varanasi","Uttar Pradesh","India",221001L);

        Branch branch1 = new Branch("PCM","Physics-Chemistry-Maths");
        Branch branch2 = new Branch("PCB","Physics-Chemistry-Biology");
        Branch branch3 = new Branch("COMM","Commerce");

        Student student1 = new Student("ash-15071989","Ashwarya Narayan Singh",LocalDate.of(1989,7,15),'M');
        Student student2 = new Student("ajt-10051989","Ajit Yadav",LocalDate.of(1989,5,10),'M');
        Student student3 = new Student("krt-14021990","Kriti Kapoor",LocalDate.of(1990,2,14),'F');

        Teacher teacher1 = new Teacher("lal-I","Lal Chand",LocalDate.of(1960,6,30),true,30.00,LocalDate.of(1985,4,24));
        Teacher teacher2 = new Teacher("man-I","Manoj Tiwari",LocalDate.of(1975,3,23),false,20.00,LocalDate.of(1997,2,28));
        Teacher teacher3 = new Teacher("rpd-I","Ramapatit Dixit",LocalDate.of(1970,1,21),true,21.00,LocalDate.of(1995,7,31));
        Teacher teacher4 = new Teacher("prf-I","Prafull Pandey",LocalDate.of(1972,2,25),false,16.00,LocalDate.of(2000,10,16));

        Qualification qualification1 = new Qualification("Bsc-Mathematics");
        Qualification qualification2 = new Qualification("Eng-Honours");
        Qualification qualification3 = new Qualification("Hindi-Honours");
        Qualification qualification4 = new Qualification("Chemistry-PhD");
        Qualification qualification5 = new Qualification("Sports-Honours");

        Subject subject1 = new Subject("Math-101","Mathematics",false);
        Subject subject2 = new Subject("Chem-101","Chemistry",false);
        Subject subject3 = new Subject("Phy-101","Physics",false);
        Subject subject4 = new Subject("Eng-101","English",false);
        Subject subject5 = new Subject("Hin-101","Hindi",true);
        Subject subject6 = new Subject("Mus-101","Music",true);
        Subject subject7 = new Subject("Phed-101","Physical Education",true);
        Subject subject8 = new Subject("Ip-101","Information Practices",true);
        Subject subject9 = new Subject("San-101","Sanskrit",true);

        Address address1 = new Address(221001,"Jaitpura","Jaitpura-Thana");
        Address address2 = new Address(221002,"Madagin","Madagin-Thana");
        Address address3 = new Address(221003,"Chowk","Chowk-Thana");
        Address address4 = new Address(221004,"Lanka","Lanka-Thana");
        Address address5 = new Address(221005,"Chetganj","Chetganj-Thana");
        Address address6 = new Address(221006,"Sigra","Sigra-Thana");
        Address address7 = new Address(221007,"Nadesar","Nadesar-Thana");
        Address address8 = new Address(221008,"Luxa","Luxa-Thana");

        school.setSchoolReg(schoolReg);

        schoolReg.setSchool(school);

        school.setSchoolStudentList(student1);
        school.setSchoolStudentList(student2);
        school.setSchoolStudentList(student3);

        student1.setSchool(school);
        student2.setSchool(school);
        student3.setSchool(school);

        student1.setAddress(address1);
        student2.setAddress(address8);
        student3.setAddress(address8);

        school.setSchoolTeacherList(teacher1);
        school.setSchoolTeacherList(teacher2);

        teacher1.setSchoolId(school);
        teacher2.setSchoolId(school);
        teacher3.setSchoolId(school);
        teacher4.setSchoolId(school);

        branch1.addStudents(student1);
        branch1.addStudents(student2);
        branch2.addStudents(student3);

        teacher1.addSubjectTaughtByTeacher(subject1);
        teacher1.addSubjectTaughtByTeacher(subject3);
        teacher2.addSubjectTaughtByTeacher(subject4);

        teacher1.setAddress(address1);
        teacher2.setAddress(address2);
        teacher3.setAddress(address3);
        teacher4.setAddress(address4);

        subject1.setTeacherTeachingSubject(teacher1);
        subject3.setTeacherTeachingSubject(teacher1);
        subject9.setTeacherTeachingSubject(teacher1);

        subject4.setTeacherTeachingSubject(teacher2);
        subject7.setTeacherTeachingSubject(teacher2);

        teacher1.setStudentList(student1);
        teacher1.setStudentList(student3);
        teacher2.setStudentList(student2);

        teacher1.setQualification(qualification1);
        teacher2.setQualification(qualification2);
        teacher3.setQualification(qualification3);
        teacher4.setQualification(qualification5);


        entityManager.persist(school);

        entityManager.persist(schoolReg);

        entityManager.persist(branch1);
        entityManager.persist(branch2);
        entityManager.persist(branch3);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
        entityManager.persist(teacher4);

        entityManager.persist(qualification1);
        entityManager.persist(qualification2);
        entityManager.persist(qualification3);
        entityManager.persist(qualification4);
        entityManager.persist(qualification5);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);
        entityManager.persist(subject4);
        entityManager.persist(subject5);
        entityManager.persist(subject6);
        entityManager.persist(subject7);
        entityManager.persist(subject8);
        entityManager.persist(subject9);

        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(address3);
        entityManager.persist(address4);
        entityManager.persist(address5);
        entityManager.persist(address6);
        entityManager.persist(address7);
        entityManager.persist(address8);

    }

}
