package com.org.service;

import com.org.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Map<Integer, Map<String, List<String>>> getPeopleOnAddress() {
        List<Object[]> peopleOnAddress = addressRepository.getPeopleOnAddress();

        //Object[] objects = peopleOnAddress.get(1);

        List<String> obj = Arrays.asList("one", "two", "three", "two", "two", "one");
    /*    Map<String, Long> collect = obj.stream()
                .collect(
                        Collectors.groupingBy(Function.identity()
                                , Collectors.counting())
                );*/

        peopleOnAddress.stream()
                .collect(
                        Collectors.groupingBy(objects -> (int) objects[0]
                                , Collectors.groupingBy(o -> {
                                            if (o[1] != null && o[2] == null) {
                                                return "Student";
                                            }
                                            if (o[1] == null && o[2] != null) {
                                                return "Teacher";
                                            }
                                            return "Teacher";
                                        },
                                        Collectors.toList()
                                )
                        ));

        peopleOnAddress.stream()
                .collect(
                        Collectors.groupingBy(objects -> (int) objects[0]
                                , Collectors.groupingBy(o -> {
                                            if (o[1] != null && o[2] == null) {
                                                return "Student";
                                            }
                                            if (o[1] == null && o[2] != null) {
                                                return "Teacher";
                                            }
                                            return "Teacher";
                                        },
                                        Collectors.mapping(objects -> (String)objects[1]
                                        ,Collectors.toList()
                                        )
                                )
                        ));

/*        System.out.println(objects[0]);
        System.out.println(objects[1]);
        System.out.println(objects[2]);*/

        //System.out.println(collect);
        
        return null;
    }
}
