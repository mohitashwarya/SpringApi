package com.org.repository;

import com.org.entity.School;

import java.util.Optional;

public interface SchoolRepository {

    public Optional<School> getSchoolDetailsById(String schoolCode);
}
