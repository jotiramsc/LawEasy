package com.legal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.legal.domain.TimeLineDomain;

public interface TimeLineRepository extends PagingAndSortingRepository<TimeLineDomain, Long> {

	List<TimeLineDomain> findByMatterId(Long matterId, Pageable pageable);
}
