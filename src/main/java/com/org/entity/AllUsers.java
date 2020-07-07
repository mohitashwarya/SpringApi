package com.org.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AllUsers implements Serializable {

	private static final long serialVersionUID = -8968830839006496038L;

	@Id
    private int userId;

    private String userName;

    private String userPswd;

    private String userEmail;

    private LocalDate creationDate;

    public boolean userEnableStatus;

    public boolean userLockedStatus;

    public boolean userAuthenticationStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Roles",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "roleId") })
    public Set<Roles> rolesAssociated = new HashSet<>();

    public AllUsers(int userId, String userName, String userPswd, String userEmail, LocalDate creationDate, boolean userEnableStatus, boolean userLockedStatus, boolean userAuthenticationStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userPswd = userPswd;
        this.userEmail = userEmail;
        this.creationDate = creationDate;
        this.userEnableStatus = userEnableStatus;
        this.userLockedStatus = userLockedStatus;
        this.userAuthenticationStatus = userAuthenticationStatus;
    }

    public AllUsers() {
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isUserEnableStatus() {
        return userEnableStatus;
    }

    public void setUserEnableStatus(boolean userEnableStatus) {
        this.userEnableStatus = userEnableStatus;
    }

    public boolean isUserLockedStatus() {
        return userLockedStatus;
    }

    public void setUserLockedStatus(boolean userLockedStatus) {
        this.userLockedStatus = userLockedStatus;
    }

    public boolean isUserAuthenticationStatus() {
        return userAuthenticationStatus;
    }

    public void setUserAuthenticationStatus(boolean userAuthenticationStatus) {
        this.userAuthenticationStatus = userAuthenticationStatus;
    }

    public Set<Roles> getRolesAssociated() {
        return rolesAssociated;
    }

    public void setRolesAssociated(Set<Roles> rolesAssociated) {
        this.rolesAssociated = rolesAssociated;
    }

    public void addRoles(Roles roles) {
        this.rolesAssociated.add(roles);
    }
}
