package com.yao.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class myAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("authentication============");
		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
