package com.org.repository;

import com.org.entity.Branch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class BranchRepositoryImpl implements BranchRepository{

    @PersistenceContext
    private EntityManager entityManager;

/*    @Override
    public Optional<Branch> getSingleBranchById(String branchId) {
        System.out.println("In Repository!!!");
        String sql = "select br from Branch br join fetch br.students where br.streamCode =:branchId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("branchId", branchId);
        Branch singleResult = (Branch) query.getSingleResult();

        return Optional.ofNullable(singleResult);
        //return Optional.ofNullable(entityManager.find(Branch.class, branchId));
    }*/

    @Override
    public Optional<Branch> getSingleBranchById(String branchId) {
        System.out.println("In Repository!!!");
        String sql = "select br from Branch br join fetch br.students where br.streamCode =:branchId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("branchId", branchId);
        Branch singleResult = (Branch) query.getSingleResult();
        
        return Optional.ofNullable(singleResult);
            //return Optional.ofNullable(entityManager.find(Branch.class, branchId));
    }
}
