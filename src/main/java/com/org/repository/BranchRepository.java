package com.org.repository;

import com.org.entity.Branch;

import java.util.Optional;

public interface BranchRepository {

    public Optional<Branch> getSingleBranchById(String branchId);
}
