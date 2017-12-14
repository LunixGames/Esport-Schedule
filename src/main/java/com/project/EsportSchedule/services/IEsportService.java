package com.project.EsportSchedule.services;

import org.springframework.http.ResponseEntity;

public interface IEsportService {
	public ResponseEntity<?> getAllSports();
	public ResponseEntity<?> getSportById(int id);
}
