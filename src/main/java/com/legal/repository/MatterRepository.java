package com.legal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legal.domain.MatterDomain;

public interface MatterRepository extends JpaRepository<MatterDomain, Long> {

}
