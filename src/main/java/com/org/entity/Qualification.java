package com.org.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Qualification implements Serializable {

	private static final long serialVersionUID = -8988076601893148433L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String degree;

    public Qualification() {
    }

    public Qualification(String degree) {
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
