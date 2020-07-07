package com.org.service;

import com.org.util.Utility;
import com.org.dto.SchoolVO;
import com.org.entity.School;
import com.org.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public Optional<SchoolVO> getSchoolDetailsById(String schoolCode) {

        Optional<School> schoolDetailsById = schoolRepository.getSchoolDetailsById(schoolCode);
        
        schoolDetailsById = null;

        Optional<SchoolVO> schoolVO = schoolDetailsById.map(Utility::toSchoolVO);
        return schoolVO;
    }
}
