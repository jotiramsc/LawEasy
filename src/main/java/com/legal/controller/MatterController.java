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

import com.legal.model.MatterModel;
import com.legal.service.MatterService;
import com.legal.service.RecordNotFoundException;


@RestController
@RequestMapping("/matters")
public class MatterController 
{
    @Autowired
    MatterService matterService;
 
    @GetMapping
    public ResponseEntity<List<MatterModel>> getAllMatters() {
        List<MatterModel> list = matterService.getAllMatters(); 
        return new ResponseEntity<List<MatterModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<MatterModel> getMatterById(@PathVariable("id") Long id) throws RecordNotFoundException {
        MatterModel entity = matterService.getMatterById(id); 
        return new ResponseEntity<MatterModel>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<MatterModel> createOrUpdateMatter(MatterModel matter) throws RecordNotFoundException {
        MatterModel updated = matterService.createOrUpdateMatter(matter);
        return new ResponseEntity<MatterModel>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteMatterById(@PathVariable("id") Long id)throws RecordNotFoundException {
        matterService.deleteMatterById(id);
        return HttpStatus.OK;
    }
 
}