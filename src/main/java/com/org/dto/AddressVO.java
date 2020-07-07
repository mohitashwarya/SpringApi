package com.org.dto;

public class AddressVO {

    private int areaPin;
    private String areaName;
    private String policeStation;

    public AddressVO() {
    }

    public int getAreaPin() {
        return areaPin;
    }

    public void setAreaPin(int areaPin) {
        this.areaPin = areaPin;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }
}
