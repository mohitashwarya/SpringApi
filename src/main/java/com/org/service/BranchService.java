package com.org.service;

import com.org.dto.BranchVO;
import com.org.entity.Branch;

import java.util.Optional;

public interface BranchService {

    public Optional<BranchVO> getSingleBranchById(String branchId);
    public Optional<Branch> getSingleBranchByIdEntity(String branchId);
}
