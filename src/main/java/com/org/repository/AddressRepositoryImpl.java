package com.org.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getPeopleOnAddress() {
        String sql = "select ad.areaPin, st.studentName, tc.teacherName from address ad \n" +
                "left join student st on ad.areaPin = st.addressFK\n" +
                "left join teacher tc on ad.areaPin = tc.addressFK";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = nativeQuery.getResultList();
        return resultList;
    }
}
