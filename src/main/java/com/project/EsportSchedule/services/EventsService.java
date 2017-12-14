package com.project.EsportSchedule.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.EsportSchedule.data.IEventsDAO;
import com.project.EsportSchedule.models.Event;

@Service
public class EventsService implements IEventsService {
	
	private IEventsDAO database;
	
	@Autowired
	public EventsService(IEventsDAO eventsDAO) {
		database = eventsDAO;
	}

	@Override
	public ResponseEntity<?> getAllEvents() {
		List<Event> allEvents = database.getAllEvents();
		
		if(allEvents == null)
			return new ResponseEntity<List<Event>>(HttpStatus.OK);
		
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllEventsByDate(int date, int[] ids) {
		String newDate = Integer.toString(date);
		String esportIds = null;
		
		if(newDate.length() != 4 && newDate.length() != 6 && newDate.length() != 8) {
			return new ResponseEntity<String>("Invalid date format",HttpStatus.BAD_REQUEST);
		}
		
		for(int id : ids) {
			if(esportIds != null && esportIds.length() > 0) {
				esportIds += "," + Integer.toString(id);
			} else {
				esportIds = Integer.toString(id);
			}
		}
	
		List<Event> allEvents = database.getAllEventsByDate(date, esportIds);
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}

}
