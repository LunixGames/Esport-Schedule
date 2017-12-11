package com.project.EsportSchedule.services;

import org.springframework.http.ResponseEntity;

public interface IEventsService {
	public ResponseEntity<?> getAllEvents();
	public ResponseEntity<?> getAllEventsByDate(String date);
}
