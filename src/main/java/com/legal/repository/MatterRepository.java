package com.legal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.legal.domain.MatterDomain;

public interface MatterRepository extends PagingAndSortingRepository<MatterDomain, Long> {
	Page<MatterDomain> findAll(Pageable pageable);
}
