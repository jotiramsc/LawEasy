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
public class MatterService implements Mappable<MatterDomain> {
	@Autowired
	MatterRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public List<MatterModel> getAllMatters() {
		List<MatterDomain> matterList = repository.findAll();

		if (matterList.size() > 0) {
			return this.convertToModelList(matterList);
		} else {
			return new ArrayList<MatterModel>();
		}
	}

	public MatterModel getMatterById(Long id) throws RecordNotFoundException {
		Optional<MatterDomain> matter = repository.findById(id);

		if (matter.isPresent()) {
			return  convertToModel(matter.get());
		} else {
			throw new RecordNotFoundException("No matter record exist for given id");
		}
	}

	public MatterModel createOrUpdateMatter(MatterModel model) throws RecordNotFoundException {
		return  convertToModel(repository.save(convertToDomain(model)));

	}
	

	public void deleteMatterById(Long id) throws RecordNotFoundException {
		Optional<MatterDomain> matter = repository.findById(id);

		if (matter.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Matter record exist for given id");
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
	public List<MatterModel> convertToModelList(List domainlist) {
		return (List<MatterModel>) domainlist.parallelStream().map(d -> this.convertToModel(d))
				.collect(Collectors.toList());
	}

	@Override
	public List<MatterDomain> convertToDomainList(List modelList) {
		return (List<MatterDomain>) modelList.parallelStream().map(m -> this.convertToDomain(m))
				.collect(Collectors.toList());
	}

}
