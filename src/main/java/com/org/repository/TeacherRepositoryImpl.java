package com.org.repository;

import com.org.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getStuentsCountUnderTeacers() {
        String sql = "select count(s.studentCode) as studentsTaught, t.teacherName from teacher t \n" +
                "left join student s on t.teacherCode = s.teacherFK group by t.teacherName;";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = nativeQuery.getResultList();
        return resultList;
    }

    @Override
    public Optional<List<Teacher>> getStudentsUnderTeachers() {

        //String sql = "select tr from Teacher tr left join fetch tr.studentList";
        String sql = "select distinct tr from Teacher tr left join fetch tr.studentList";
        //String sql = "select tr from Teacher tr";

        Query query = entityManager.createQuery(sql);
        List<Teacher> resultList = query.getResultList();
        System.out.println(resultList);
        System.out.println(resultList.size());

        return Optional.ofNullable(resultList);
    }
}
