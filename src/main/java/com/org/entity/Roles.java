package com.org.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Roles implements Serializable {

	private static final long serialVersionUID = -1956488213508335697L;

	@Id
    public String roleId;

    public String roleDesc;

    public String getRoleId() {
        return roleId;
    }

    public Roles(String roleId, String roleDesc) {
        this.roleId = roleId;
        this.roleDesc = roleDesc;
    }

    public Roles() {
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
