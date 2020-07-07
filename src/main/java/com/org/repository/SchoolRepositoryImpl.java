package com.org.repository;

import com.org.entity.School;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class SchoolRepositoryImpl implements SchoolRepository{

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    public Optional<School> getSchoolDetailsById(String schoolCode) {

        System.out.println("SChool Repository Call Starts!!!");
        School school = entityManager.find(School.class, schoolCode);
        System.out.println("SChool Repository Call Ends!!!");
        return Optional.ofNullable(school);
    }
}
