package com.legal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.legal.domain.TimeLineDomain;
import com.legal.model.TimeLineModel;
import com.legal.repository.TimeLineRepository;

@Service
public class TimeLineService implements Mappable<TimeLineDomain, TimeLineModel> {
	@Autowired
	TimeLineRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public List<TimeLineModel> getAllTimeLinesBymatterId(Long matterId,Integer start,Integer limit) {
		Pageable pageable = PageRequest.of(start, limit,Sort.by("modifiedDate").descending());
		List<TimeLineDomain> timeLineList = repository.findByMatterId(matterId, pageable);

		if (!timeLineList.isEmpty()) {
			return this.convertToModelList(timeLineList);
		} else {
			return new ArrayList<>();
		}
	}

	public TimeLineModel getTimeLineById(Long id) throws LowException {
		Optional<TimeLineDomain> timeLine = repository.findById(id);

		if (timeLine.isPresent()) {
			return convertToModel(timeLine.get());
		} else {
			throw new LowException("No TimeLine record exist for given id");
		}
	}

	public TimeLineModel createOrUpdateTimeLine(TimeLineModel model) {
		return convertToModel(repository.save(convertToDomain(model)));

	}

	public void deleteTimeLineById(Long id) throws LowException {
		Optional<TimeLineDomain> timeLine = repository.findById(id);

		if (timeLine.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new LowException("No TimeLine record exist for given id");
		}
	}

	@Override
	public TimeLineModel convertToModel(Object domainObject) {
		return modelMapper.map(domainObject, TimeLineModel.class);
	}

	@Override
	public TimeLineDomain convertToDomain(Object modelObject) {
		return modelMapper.map(modelObject, TimeLineDomain.class);
	}

	@Override
	public List convertToModelList(List<TimeLineDomain> domainlist) {
		return domainlist.parallelStream().map(this::convertToModel).collect(Collectors.toList());
	}

	@Override
	public List convertToDomainList(List<TimeLineModel> modelList) {
		return modelList.parallelStream().map(this::convertToDomain).collect(Collectors.toList());
	}

}
