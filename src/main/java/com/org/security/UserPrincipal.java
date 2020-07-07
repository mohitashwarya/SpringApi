package com.org.security;

import com.org.entity.AllUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    
	private static final long serialVersionUID = -4433309079354789314L;

    private AllUsers allUsers;
    
    public UserPrincipal(AllUsers allUsers) {
        this.allUsers = allUsers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Optional.ofNullable(allUsers.getRolesAssociated()
                .stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRoleId())).collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
        
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return allUsers.getUserPswd();
    }

    @Override
    public String getUsername() {
        return String.valueOf(allUsers.getUserId());
    }

    @Override
    public boolean isAccountNonExpired() {
        return allUsers.isUserAuthenticationStatus();
    }

    @Override
    public boolean isAccountNonLocked() {
        return allUsers.isUserLockedStatus();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return allUsers.isUserEnableStatus();
    }

    @Override
    public boolean isEnabled() {
        return allUsers.isUserEnableStatus();
    }
}
