package com.legal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legal.domain.PartyDomain;
import com.legal.model.PartyModel;
import com.legal.repository.PartyRepository;


@Service
public class PartyService implements Mappable<PartyDomain> {
	@Autowired
	PartyRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public List<PartyModel> getAllParties() {
		List<PartyDomain> partyList = repository.findAll();

		if (partyList.size() > 0) {
			return this.convertToModelList(partyList);
		} else {
			return new ArrayList<PartyModel>();
		}
	}

	public PartyModel getPartyById(Long id) throws RecordNotFoundException {
		Optional<PartyDomain> party = repository.findById(id);

		if (party.isPresent()) {
			return  convertToModel(party.get());
		} else {
			throw new RecordNotFoundException("No party record exist for given id");
		}
	}

	public PartyModel createOrUpdateParty(PartyModel model) throws RecordNotFoundException {
		return  convertToModel(repository.save(convertToDomain(model)));

	}
	

	public void deletePartyById(Long id) throws RecordNotFoundException {
		Optional<PartyDomain> party = repository.findById(id);

		if (party.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Party record exist for given id");
		}
	}

	@Override
	public PartyModel convertToModel(Object domainObject) {
		return modelMapper.map(domainObject, PartyModel.class);
	}

	@Override
	public PartyDomain convertToDomain(Object modelObject) {
		return modelMapper.map(modelObject, PartyDomain.class);
	}

	@Override
	public List<PartyModel> convertToModelList(List domainlist) {
		return (List<PartyModel>) domainlist.parallelStream().map(d -> this.convertToModel(d))
				.collect(Collectors.toList());
	}

	@Override
	public List<PartyDomain> convertToDomainList(List modelList) {
		return (List<PartyDomain>) modelList.parallelStream().map(m -> this.convertToDomain(m))
				.collect(Collectors.toList());
	}

}

