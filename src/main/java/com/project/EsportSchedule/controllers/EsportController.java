package com.project.EsportSchedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.EsportSchedule.services.IEsportService;

@RestController
@RequestMapping(value = "/api")
public class EsportController {

	private IEsportService service;
	
	@Autowired
	public EsportController(IEsportService workingService) {
		service = workingService;
	}
	
	//GET all esports
	@RequestMapping(value = "/sports", method = RequestMethod.GET)
	public ResponseEntity<?> getAllSports () {
		return service.getAllSports();
	}
	
	//GET esport by id
	@RequestMapping(value = "/sports", method = RequestMethod.GET, params = "id")
	public ResponseEntity<?> getSportById (@RequestParam(value = "id", defaultValue = "0") int id) {
		return service.getSportById(id);
	}
	
	//GET esport by name
	@RequestMapping(value = "/sports", method = RequestMethod.GET, params = "name")
	public ResponseEntity<?> getSportByName(@RequestParam(value = "name", defaultValue = "") String name) {
		return service.getSportByName(name);
	}
}
