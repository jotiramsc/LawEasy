package com.legal.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.legal.domain.UserDomain;
import com.legal.model.UserModel;
import com.legal.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserModel loadUserByUsername(String username) {

		return modelMapper.map(userRepository.findByUsername(username), UserModel.class);

	}

	public UserModel saveUser(UserModel userModel) throws LowException {

		final UserDomain userDetails = userRepository.findByUsername(userModel.getUsername());
		if (null != userDetails) {
			throw new LowException("USER_ALREADY_EXIST");
		} else {
			UserDomain detail = modelMapper.map(userModel, UserDomain.class);
			detail.setPassword(bcryptEncoder.encode(detail.getPassword()));
			return modelMapper.map(userRepository.save(detail), UserModel.class);

		}

	}

}
