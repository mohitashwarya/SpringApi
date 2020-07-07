package com.org.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.org.entity.AllUsers;

@Component
@Transactional
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    PasswordEncoder passwordEncoder; 

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
        CustomAuthenticationToken token = (CustomAuthenticationToken)authentication;
        System.out.println("--------- : "+authentication.getPrincipal());
        System.out.println("--------- : "+token.getName());
        
        

        AllUsers allUsers = entityManager.find(AllUsers.class, Integer.parseInt(token.getName()));

        UserPrincipal userPrincipal = new UserPrincipal(allUsers);
        
        System.out.println("^^^^^ : "+passwordEncoder.matches((CharSequence) token.getCredentials(), userPrincipal.getPassword()));

        if(!userPrincipal.isEnabled()){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%");
            throw new BadCredentialsException("User Is Not Enabled");
        }
        System.out.println(token.getCredentials());
        System.out.println(userPrincipal.getPassword());
        //CustomAuthenticationToken tok = new CustomAuthenticationToken(userPrincipal, userPrincipal.getPassword(), userPrincipal.getAuthorities());
        CustomAuthenticationToken tok = new CustomAuthenticationToken(userPrincipal.getUsername(), userPrincipal.getPassword(), userPrincipal.getAuthorities());
        tok.setDetails(authentication.getDetails());
        return tok;
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        //return UsernamePasswordAuthenticationToken.class.equals(authentication);
        return CustomAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
