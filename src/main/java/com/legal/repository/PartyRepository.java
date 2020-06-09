package com.legal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legal.domain.PartyDomain;

public interface PartyRepository extends JpaRepository<PartyDomain, Long> {

}
