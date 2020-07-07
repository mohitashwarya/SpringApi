package com.org.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.org.constants.SecurityConstants;


public class CustomAuthorizationFilter extends BasicAuthenticationFilter {

    public CustomAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.startsWith(SecurityConstants.BEARER_PREFIX)) {
        	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        	chain.doFilter(request, response);
        	return;        
        	}
        
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(authorization));

        chain.doFilter(request, response);
    }
    
    private CustomAuthenticationToken getAuthentication(String authHeader) {
    	
    	if(authHeader != null) {
    		Map<String, Claim> claims = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY.getBytes()))
    		.build()
    		.verify(authHeader.replace(SecurityConstants.BEARER_PREFIX, ""))
    		.getClaims();
    		
    		System.out.println("Map Value : "+claims);
    		System.out.println("----- : "+claims.get("myName").asString());
    		System.out.println("!!!! : "+claims.get("myPswd").asString());
    		Claim claim = claims.get("myRoles");
    		System.out.println(claim.asList(SimpleGrantedAuthority.class));
    		
    		if(!claims.isEmpty()) {
    			//return new CustomAuthenticationToken(attribute, claims.get("myPswd").asString(), attribute.getAuthorities());
    			return new CustomAuthenticationToken(claims.get("myName").asString(), claims.get("myPswd").asString(), claims.get("myRoles").asList(SimpleGrantedAuthority.class));
    		}
    	}
    	
    	return null;
    }
}
