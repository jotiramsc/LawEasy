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
public class PartyService implements Mappable<PartyDomain, PartyModel> {
	@Autowired
	PartyRepository repository;

	@Autowired
	ModelMapper modelMapper;

	public List<PartyModel> getAllParties() {
		List<PartyDomain> partyList = repository.findAll();

		if (!partyList.isEmpty()) {
			return this.convertToModelList(partyList);
		} else {
			return new ArrayList<>();
		}
	}

	public List<PartyModel> getAllPartiesByMatterId(Long matterID) {
		List<PartyDomain> partyList = repository.findByMatterId(matterID);

		if (!partyList.isEmpty()) {
			return this.convertToModelList(partyList);
		} else {
			return new ArrayList<>();
		}
	}
	public PartyModel getPartyById(Long id) throws LowException {
		Optional<PartyDomain> party = repository.findById(id);

		if (party.isPresent()) {
			return convertToModel(party.get());
		} else {
			throw new LowException("No party record exist for given id");
		}
	}

	public PartyModel createOrUpdateParty(PartyModel model)  {
		return convertToModel(repository.save(convertToDomain(model)));

	}

	public void deletePartyById(Long id) throws LowException {
		Optional<PartyDomain> party = repository.findById(id);

		if (party.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new LowException("No Party record exist for given id");
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
	public List convertToModelList(List<PartyDomain> domainlist) {
		return domainlist.parallelStream().map(this::convertToModel).collect(Collectors.toList());
	}

	@Override
	public List convertToDomainList(List<PartyModel> modelList) {
		return modelList.parallelStream().map(this::convertToDomain).collect(Collectors.toList());
	}

}
