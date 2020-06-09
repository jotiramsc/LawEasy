package com.legal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legal.auth.JwtTokenUtil;
import com.legal.model.JwtRequest;
import com.legal.model.JwtResponse;
import com.legal.model.UserModel;
import com.legal.service.JwtUserDetailsService;
import com.legal.service.LowException;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws LowException {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws LowException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new LowException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			throw new LowException("INVALID_CREDENTIALS");
		}
	}

	public ResponseEntity registerUser(@RequestBody UserModel userModel) throws LowException {

		return ResponseEntity.ok(userDetailsService.saveUser(userModel));
	}
}