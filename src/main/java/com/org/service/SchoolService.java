package com.org.service;

import com.org.dto.SchoolVO;

import java.util.Optional;

public interface SchoolService {

    public Optional<SchoolVO> getSchoolDetailsById(String schoolCode);
}
