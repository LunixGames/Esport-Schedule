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
	public EventsService(IEventsDAO eventsDao) {
		database = eventsDao;
	}

	@Override
	public ResponseEntity<?> getAllEvents() {
		List<Event> allEvents = database.getAllEvents();
		
		if(allEvents == null)
			return new ResponseEntity<List<Event>>(HttpStatus.OK);
		
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllEventsByDate(int date, String name) {
		String newDate = Integer.toString(date);
		String esportName = null;
		
		if(newDate.length() != 4 && newDate.length() != 6 && newDate.length() != 8) {
			return new ResponseEntity<String>("Invalid date format",HttpStatus.BAD_REQUEST);
		}
		
		if(name != null && name.length() > 0) {
			for(String s : name.split(",")) {
				try {
					int id = Integer.parseInt(s);
					
					if(esportName != null && esportName.length() > 0) {
						esportName += "," + Integer.toString(id);
					} else {
						esportName = Integer.toString(id);
					}
				} catch (NumberFormatException e) {
					return new ResponseEntity<String>("Invalid esports format",HttpStatus.BAD_REQUEST);
				}
			}
		}
		
		List<Event> allEvents = database.getAllEventsByDate(date, esportName);
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}

}
