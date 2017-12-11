package com.project.EsportSchedule.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public ResponseEntity<?> getAllEventsByDate(String date) {
		String newDate = date;
		if(newDate.length() < 8)
			newDate += "01";
		
		try {
			new SimpleDateFormat("YYYYMMDD").parse(newDate);
			
		} catch (ParseException e) {
			return new ResponseEntity<String>("Invalid date format",HttpStatus.BAD_REQUEST);
		}
		
		List<Event> allEvents = database.getAllEventsByDate(date);
		
		if(allEvents == null)
			return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
		
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}

}
