package com.org.service;

import com.org.dto.AddressVO;
import com.org.dto.BranchVO;
import com.org.dto.StudentVO;
import com.org.entity.Branch;
import com.org.mapper.CustomMapper;
import com.org.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BranchServiceImpl implements  BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Qualifier("customMapperImpl")
    @Autowired
    private CustomMapper customMapper;

    @Autowired
    private ModelMapper modelMapper;

/*    @Override
    public Optional<BranchVO> getSingleBranchById(String branchId) {
        System.out.println("From Service");
        Optional<Branch> singleBranchById = branchRepository.getSingleBranchById(branchId);
        System.out.println("After Service");
        Optional<BranchVO> branchVO = singleBranchById.map(branch -> customMapper.toBranchVO(branch));
        System.out.println("Before Returning From Service");
        return branchVO;
    }*/

    @Override
    public Optional<BranchVO> getSingleBranchById(String branchId) {
        System.out.println("From Service");
        Optional<Branch> singleBranchById = branchRepository.getSingleBranchById(branchId);
        System.out.println("After Repository Call In Service!!!");
/*        singleBranchById.stream().map(branch -> {
            BranchVO bvo = new BranchVO();
            StudentVO svo = new StudentVO();
            bvo.setStreamDesc(branch.getStreamDesc());
            bvo.setStreamCode(branch.getStreamCode());
            //svo.set
            bvo.setStudents(branch.getStudents().);
            return bvo;
        });*/

        Branch branch = singleBranchById.get();
        BranchVO bvo = new BranchVO();
        bvo.setStreamDesc(branch.getStreamDesc());
        bvo.setStreamCode(branch.getStreamCode());
        List<StudentVO> collect = branch.getStudents().stream().map(stu -> {
            StudentVO svo = new StudentVO();
            svo.setStudentCode(stu.getStudentCode());
            svo.setStudentName(stu.getStudentName());
            svo.setStudentDob(stu.getStudentDob());
            svo.setStudentGender(stu.getStudentGender());
            AddressVO avo = new AddressVO();
            avo.setAreaName(stu.getAddress().getAreaName());
            avo.setAreaPin(stu.getAddress().getAreaPin());
            avo.setPoliceStation(stu.getAddress().getPoliceStation());
            svo.setAddress(avo);
            return svo;
        }).collect(Collectors.toList());

        bvo.setStudents(collect);





        //BranchVO bvo = new BranchVO();
        //bvo.setStreamDesc();

        //Optional<BranchVO> branchVO = singleBranchById.map(branch -> customMapper.toBranchVO(branch));
        //BranchVO map = modelMapper.map(branch, BranchVO.class);
        System.out.println("Before Returning From Service");
        //return branchVO;
        return Optional.ofNullable(bvo);
        //return Optional.ofNullable(map);
    }

    @Override
    public Optional<Branch> getSingleBranchByIdEntity(String branchId) {
        System.out.println("Starting Service!!!!!!!!!!!!!!!");
        Optional<Branch> singleBranchById = branchRepository.getSingleBranchById(branchId);
        System.out.println("Before Returning From Service!!!!!!!!!!!!!!!");
        return singleBranchById;
    }
}
