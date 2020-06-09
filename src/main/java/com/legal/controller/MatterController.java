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
import com.legal.service.LowException;


@RestController
@RequestMapping("/matters")
public class MatterController 
{
    @Autowired
    MatterService matterService;
 
    @GetMapping
    public ResponseEntity<List<MatterModel>> getAllMatters(@PathVariable("start") Integer start,@PathVariable("limit") Integer limit) {
        List<MatterModel> list = matterService.getAllMatters(start,limit); 
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<MatterModel> getMatterById(@PathVariable("id") Long id) throws LowException {
        MatterModel entity = matterService.getMatterById(id); 
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<MatterModel> createOrUpdateMatter(MatterModel matter) {
        MatterModel updated = matterService.createOrUpdateMatter(matter);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteMatterById(@PathVariable("id") Long id)throws LowException {
        matterService.deleteMatterById(id);
        return HttpStatus.OK;
    }
 
}