package com.org.service;

import com.org.dto.StudentVO;
import com.org.entity.Teacher;
import com.org.repository.TeacherRepository;
import com.org.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Map<String, Integer> getStuentsCountUnderTeacers() {
        List<Object[]> stuentsCountUnderTeacers = teacherRepository.getStuentsCountUnderTeacers();
        Map<String, Integer> collect = stuentsCountUnderTeacers.stream()
                .collect(Collectors.toMap(stu -> (String) stu[1], stu -> ((BigInteger)stu[0]).intValue()));

        Optional<List<Teacher>> studentsUnderTeachers = teacherRepository.getStudentsUnderTeachers();

        Map<String, Integer> collect1 = studentsUnderTeachers.get().stream().collect(Collectors
                .groupingBy(teacher -> teacher.getTeacherName()
                        , Collectors.mapping(teacher -> teacher.getStudentList().size()
                                , Collectors.reducing(0, (t1, t2) -> t1 + t2)
                        ))
        );

        return collect1;
    }

    @Override
    public Map<String, List<StudentVO>> getStudentsUnderTeachers() {

        Optional<List<Teacher>> studentsUnderTeachers = teacherRepository.getStudentsUnderTeachers();

        Stream<List<Teacher>> stream = studentsUnderTeachers.stream();
        Stream<Teacher> teacherStream = stream.flatMap(List::stream);
/*        teacherStream.collect(Collectors.groupingBy(teacher -> teacher.getTeacherName(),
         Collectors.mapping(teacher -> teacher.getStudentList(), Collectors.toList())));*/

 /*       Map<String, List<StudentVO>> collect = teacherStream.collect(Collectors.
                toMap(teacher -> teacher.getTeacherName(), teacher -> teacher.getStudentList()
                        .stream().map(Utility::toStudentVO).collect(Collectors.toList())));*/

        /*Map<String, List<StudentVO>> collect = teacherStream.collect(Collectors.toMap(teacher -> teacher.getTeacherName(), teacher -> teacher.getStudentList()
                .stream().map(Utility::toStudentVO).collect(Collectors.toList())));*/

/*        Map<String, List<StudentVO>> collect= teacherStream.collect(Collectors.toMap(teacher -> teacher.getTeacherName(),
                teacher -> teacher.getStudentList()
                .stream().map(Utility::toStudentVO).collect(Collectors.toList())
                , (l1, l2) -> l1
        ));*/

/*        Map<String, List<StudentVO>> collect = teacherStream.collect(Collectors.
                groupingBy(teacher -> teacher.getTeacherName()
                        , Collectors.filtering(teacher -> {

                                   return teacher.getStudentList().size() != 0;

                                }
                                , Collectors.reducing(new ArrayList<StudentVO>(), teacher -> teacher.getStudentList()

                                                .stream()
                                                .peek(a -> System.out.println(a))
                                                .map(Utility::toStudentVO)
                                                .peek(a -> System.out.println(a))
                                                .collect(Collectors.toList()),
                                        (list1, list2) -> list2))));*/


        Map<String, List<StudentVO>> collect = teacherStream.collect(Collectors.filtering(teacher -> !teacher.getStudentList().isEmpty()
                , Collectors.groupingBy(teacher -> teacher.getTeacherName()
                        , Collectors.reducing(new ArrayList<StudentVO>()
                                , teacher -> teacher.getStudentList().stream().map(Utility::toStudentVO).collect(Collectors.toList())
                                     , (list1, list2) -> list2))));

/*        Map<String, List<Stream<StudentVO>>> collect1 = teacherStream.collect(Collectors.groupingBy(teacher -> teacher.getTeacherName(),
                Collectors.mapping(teacher -> teacher.getStudentList().stream().map(Utility::toStudentVO),
                        Collectors.toList())));*/
/*        Map<String, List<StudentVO>> collect2 = teacherStream.collect(Collectors.groupingBy(teacher -> teacher.getTeacherName(),
                Collectors.reducing(new ArrayList<StudentVO>(), teacher -> teacher.getStudentList()
                                .stream().map(Utility::toStudentVO)
                                .peek(s -> System.out.println(s))
                                .collect(Collectors.toList()),
                        (list1, list2) -> list2)));*/

        //teacherStream.collect(Collectors.groupingBy(teacher -> teacher.getTeacherName(),;


        return collect;
    }
}
