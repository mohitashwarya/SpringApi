package com.org.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -120259425523080022L;
	
	@Id
    private int areaPin;
    private String areaName;
    private String policeStation;

    public Address() {
    }

    public Address(int areaPin, String areaName, String policeStation) {
        this.areaPin = areaPin;
        this.areaName = areaName;
        this.policeStation = policeStation;
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
