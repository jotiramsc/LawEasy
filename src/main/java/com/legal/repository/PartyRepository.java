package com.legal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.legal.domain.MatterDomain;
import com.legal.domain.PartyDomain;
import com.legal.domain.UserDomain;

public interface PartyRepository extends JpaRepository<PartyDomain, Long> {
	
	
}
