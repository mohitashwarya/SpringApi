package com.org.controller;

import com.org.dto.BranchVO;
import com.org.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping(value = "/{branchId}")
    public ResponseEntity<BranchVO> getSingleBranchById(@PathVariable String branchId){
        //branchService.getSingleBranchById(branchId);
        return ResponseEntity.of(branchService.getSingleBranchById(branchId));
    }

/*    @GetMapping(value = "/{branchId}")
    public ResponseEntity<Branch> getSingleBranchById(@PathVariable String branchId){
        //branchService.getSingleBranchById(branchId);
        Optional<Branch> singleBranchByIdEntity = branchService.getSingleBranchByIdEntity(branchId);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        return ResponseEntity.of(singleBranchByIdEntity);
    }*/

}
