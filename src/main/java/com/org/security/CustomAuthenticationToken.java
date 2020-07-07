package com.org.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -3620653683004897556L;
	
	public String firstInput;
    public String secondInput;

    public String getFirstInput() {
        return firstInput;
    }

    public void setFirstInput(String firstInput) {
        this.firstInput = firstInput;
    }

    public String getSecondInput() {
        return secondInput;
    }

    public void setSecondInput(String secondInput) {
        this.secondInput = secondInput;
    }

    public CustomAuthenticationToken(String firstInput, String secondInput) {
        super(firstInput, secondInput);
        this.firstInput = firstInput;
        this.secondInput = secondInput;
    }

//    public CustomAuthenticationToken(UserPrincipal principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
//        super(principal, credentials, authorities);
//    }

	public CustomAuthenticationToken(String principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
		// TODO Auto-generated constructor stub
		super(principal, credentials, authorities);
	}
}
