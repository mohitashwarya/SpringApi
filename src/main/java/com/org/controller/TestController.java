package com.org.controller;

import com.org.harness.GenerateAllData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TestController {

    @Autowired
    private GenerateAllData generateAllData;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/tes", produces = MediaType.APPLICATION_XML_VALUE)
    public String testMethod( Locale locale){
        System.out.println("Test Method Executed!!");
        generateAllData.genereateData();
        System.out.println(locale.getDisplayLanguage());
        System.out.println("********************** : "+messageSource.getMessage("label.error", null, locale));
        return "hellomoto";
    }
}
