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

import com.legal.domain.MatterDomain;
import com.legal.model.MatterModel;
import com.legal.repository.MatterRepository;
import com.legal.repository.PartyRepository;
import com.legal.repository.TimeLineRepository;

@Service
public class MatterService implements Mappable<MatterDomain, MatterModel> {
	@Autowired
	MatterRepository repository;
	
	@Autowired
	PartyRepository partyRepository;
	
	@Autowired
	TimeLineRepository timeLineRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<MatterModel> getAllMatters(int start, int limit) {
		Pageable pageable = PageRequest.of(start, limit,Sort.by("modifiedDate").descending());
		List<MatterDomain> matterList = repository.findAll(pageable).getContent();

		if (!matterList.isEmpty()) {
			matterList.forEach(matter -> {				
				matter.setParties(partyRepository.findByMatterId(matter.getId()));
				matter.setTimeLines(timeLineRepository.findByMatterId(matter.getId(), pageable));
			});
			return this.convertToModelList(matterList);
			
		} else {
			return new ArrayList<>();
		}
	}

	public MatterModel getMatterById(Long id) throws LowException {
		Optional<MatterDomain> matter = repository.findById(id);

		if (matter.isPresent()) {
			return convertToModel(matter.get());
		} else {
			throw new LowException("No matter record exist for given id");
		}
	}

	public MatterModel createOrUpdateMatter(MatterModel model)  {
		return convertToModel(repository.save(convertToDomain(model)));

	}

	public void deleteMatterById(Long id) throws LowException {
		Optional<MatterDomain> matter = repository.findById(id);

		if (matter.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new LowException("No Matter record exist for given id");
		}
	}

	@Override
	public List<MatterModel> convertToModelList(List<MatterDomain> domainlist) {
		return  domainlist.parallelStream().map(this::convertToModel)
				.collect(Collectors.toList());
	}

	@Override
	public List<MatterDomain> convertToDomainList(List<MatterModel> modelList) {
		return modelList.parallelStream().map(this::convertToDomain)
				.collect(Collectors.toList());
	}

	@Override
	public MatterModel convertToModel(MatterDomain domainObject) {
		return modelMapper.map(domainObject, MatterModel.class);
	}

	@Override
	public MatterDomain convertToDomain(MatterModel modelObject) {
		return modelMapper.map(modelObject, MatterDomain.class);
	}

}
