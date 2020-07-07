package com.org.controller;

import com.org.dto.SchoolVO;
import com.org.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping(value = "/{schoolId}")
    public ResponseEntity<SchoolVO> getSingleBranchById(@PathVariable String schoolId){
        //branchService.getSingleBranchById(branchId);
        return ResponseEntity.of(schoolService.getSchoolDetailsById(schoolId));
    }
}
