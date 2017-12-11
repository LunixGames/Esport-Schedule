package com.project.EsportSchedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.EsportSchedule.services.IEventsService;

@RestController
@RequestMapping(value = "/api")
public class EventsController {
	private IEventsService service;
	
	@Autowired
	public EventsController(IEventsService workService) {
		service = workService;
	}
	
	@RequestMapping(value = "/events",method = RequestMethod.GET)
	public ResponseEntity<?> getAllEvents() {
		return service.getAllEvents();
	}
	
	@RequestMapping(value = "/events",params = "date",method = RequestMethod.GET)
	public ResponseEntity<?> getAllEventsByDate(@RequestParam(value = "date",defaultValue = "0") String date) {
		return service.getAllEventsByDate(date);
	}
}
