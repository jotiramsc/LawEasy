package com.legal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legal.model.PartyModel;
import com.legal.service.LowException;
import com.legal.service.PartyService;

@RestController
@RequestMapping("/parties")
public class PartyController {
	@Autowired
	PartyService partyService;

	@GetMapping
	public ResponseEntity<List<PartyModel>> getAllPartys() {
		List<PartyModel> list = partyService.getAllParties();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PartyModel> getPartyById(@PathVariable("id") Long id) throws LowException {
		PartyModel entity = partyService.getPartyById(id);
		return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PartyModel> createOrUpdateParty(PartyModel party)  {
		PartyModel updated = partyService.createOrUpdateParty(party);
		return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deletePartyById(@PathVariable("id") Long id) throws LowException {
		partyService.deletePartyById(id);
		return HttpStatus.OK;
	}

}