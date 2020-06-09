package com.legal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;          

import com.legal.domain.PartyDomain;

public interface PartyRepository extends JpaRepository<PartyDomain, Long> {

	List<PartyDomain> findByMatterId(Long matterId);
}
