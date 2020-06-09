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

import com.legal.model.TimeLineModel;
import com.legal.service.LowException;
import com.legal.service.TimeLineService;

@RestController
@RequestMapping("/timelines")
public class TimeLineController {
	@Autowired
	TimeLineService timeLineService;

	@GetMapping
	public ResponseEntity<List<TimeLineModel>> getAllTimeLines(@PathVariable("matterid") Long matterId,@PathVariable("start") Integer start,
			@PathVariable("limit") Integer limit) {
		List<TimeLineModel> list = timeLineService.getAllTimeLinesBymatterId(matterId,start, limit);
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TimeLineModel> getTimeLineById(@PathVariable("id") Long id) throws LowException {
		TimeLineModel entity = timeLineService.getTimeLineById(id);
		return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TimeLineModel> createOrUpdateTimeLine(TimeLineModel timeLine) {
		TimeLineModel updated = timeLineService.createOrUpdateTimeLine(timeLine);
		return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteTimeLineById(@PathVariable("id") Long id) throws LowException {
		timeLineService.deleteTimeLineById(id);
		return HttpStatus.OK;
	}

}