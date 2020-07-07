package com.org.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.constants.SecurityConstants;


public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationFilter.class);

	private AuthenticationProvider authenticationProvider;

	public CustomAuthenticationFilter(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

		System.out.println("#####################################3");
		CustomAuthenticationToken token = null;

		try {
			InputObject inputObject = new ObjectMapper().readValue(request.getInputStream(), InputObject.class);
			//System.out.println("PSWD " +inputObject.getSecondInput());
			token = new CustomAuthenticationToken(inputObject.getFirstInput(), inputObject.getSecondInput());
			super.setDetails(request, token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authenticationProvider.authenticate(token);

	}


	@Override protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain, Authentication authResult)
					throws IOException, ServletException {
		System.out.println("***********************************");
		
//		List<SimpleGrantedAuthority> collect = authResult.getAuthorities()
//				.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).collect(Collectors.toList());
		
		List<String> collect = authResult.getAuthorities()
				.stream().map(s -> s.getAuthority()).collect(Collectors.toList());
		
		System.out.println("***** : "+collect);
		
		String sign = JWT.create()
				.withSubject(authResult.getName())
				.withExpiresAt(new Date(System.currentTimeMillis()+ SecurityConstants.EXPIRATION_TIME))
				.withClaim("myName", authResult.getName())
				.withClaim("myPswd", authResult.getCredentials().toString())
				.withClaim("myRoles", collect)
				.sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY.getBytes()));
		
		System.out.println("Token : "+sign);
		logger.info("Token : "+sign);
		response.addHeader(SecurityConstants.AUTH_HEADER, SecurityConstants.BEARER_PREFIX+sign);

		}

}
