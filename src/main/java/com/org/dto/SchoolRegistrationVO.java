package com.org.dto;

public class SchoolRegistrationVO {

    private String registrationNo;
    private int affiliatonClass;
    private String founderName;
    private String schoolInCity;
    private String schoolInState;
    private String country;
    private long pinCode;
    private SchoolVO school;

    public SchoolRegistrationVO() {
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

    public SchoolVO getSchool() {
        return school;
    }

    public void setSchool(SchoolVO school) {
        this.school = school;
    }
}
