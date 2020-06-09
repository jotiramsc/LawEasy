package com.legal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legal.domain.MatterDomain;
import com.legal.model.MatterModel;
import com.legal.repository.MatterRepository;

@Service
public class MatterService implements Mappable<MatterDomain, MatterModel> {
	@Autowired
	MatterRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public List<MatterModel> getAllMatters() {
		List<MatterDomain> matterList = repository.findAll();

		if (!matterList.isEmpty()) {
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
	public MatterModel convertToModel(Object domainObject) {
		return modelMapper.map(domainObject, MatterModel.class);
	}

	@Override
	public MatterDomain convertToDomain(Object modelObject) {
		return modelMapper.map(modelObject, MatterDomain.class);
	}

	@Override
	public List convertToModelList(List<MatterDomain> domainlist) {
		return  domainlist.parallelStream().map(this::convertToModel)
				.collect(Collectors.toList());
	}

	@Override
	public List convertToDomainList(List<MatterModel> modelList) {
		return modelList.parallelStream().map(this::convertToModel)
				.collect(Collectors.toList());
	}

}
