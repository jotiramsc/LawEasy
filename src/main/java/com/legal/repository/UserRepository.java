package com.legal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.legal.domain.UserDomain;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
	
	public UserDomain findByUsername(String username);
}
