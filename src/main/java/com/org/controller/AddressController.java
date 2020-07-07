package com.org.controller;

import com.org.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/getPeopleOnAddress")
    public String getPeopleOnAddress(){
        addressService.getPeopleOnAddress();
        return "Hello!!!!!";
    }
}
