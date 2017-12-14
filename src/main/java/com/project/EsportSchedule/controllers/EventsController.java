package com.project.EsportSchedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.EsportSchedule.services.IEventsService;

@RestController
@RequestMapping(value = "/api/events")
public class EventsController {
	
	private IEventsService service;
	
	@Autowired
	public EventsController(IEventsService workService) {
		service = workService;
	}
	
	//GET All event
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<?> getAllEvents() {
		return service.getAllEvents();
	}
	
	//GET event between date and with esportid
	@RequestMapping(value = "",params = "date",method = RequestMethod.GET)
	public ResponseEntity<?> getAllEventsByDate(@RequestParam(value = "date",defaultValue = "0") int date,
			@RequestParam(value = "esports", defaultValue = "") int[] ids) {
		return service.getAllEventsByDate(date, ids);
	}
}
