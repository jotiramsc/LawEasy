package com.legal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.legal.domain.MatterDomain;

public interface MatterRepository extends JpaRepository<MatterDomain, Long> {

}
