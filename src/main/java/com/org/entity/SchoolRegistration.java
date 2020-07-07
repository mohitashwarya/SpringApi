package com.org.entity;

import javax.persistence.*;

@Entity
public class SchoolRegistration {

    @Id
    private String registrationNo;
    private int affiliatonClass;
    private String founderName;
    private String schoolInCity;
    private String schoolInState;
    private String country;
    private long pinCode;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "schoolFK")
    private School school;

    public SchoolRegistration() {
    }

    public SchoolRegistration(String registrationNo, int affiliatonClass, String founderName, String schoolInCity, String schoolInState, String country, long pinCode) {
        this.registrationNo = registrationNo;
        this.affiliatonClass = affiliatonClass;
        this.founderName = founderName;
        this.schoolInCity = schoolInCity;
        this.schoolInState = schoolInState;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public int getAffiliatonClass() {
        return affiliatonClass;
    }

    public void setAffiliatonClass(int affiliatonClass) {
        this.affiliatonClass = affiliatonClass;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public String getSchoolInCity() {
        return schoolInCity;
    }

    public void setSchoolInCity(String schoolInCity) {
        this.schoolInCity = schoolInCity;
    }

    public String getSchoolInState() {
        return schoolInState;
    }

    public void setSchoolInState(String schoolInState) {
        this.schoolInState = schoolInState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
