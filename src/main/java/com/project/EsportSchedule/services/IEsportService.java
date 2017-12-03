package com.project.EsportSchedule.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.project.EsportSchedule.models.Sport;

public interface IEsportService {
	public ResponseEntity<?> getAllSports();
	public ResponseEntity<?> getSportById(int id);
	public ResponseEntity<?> getSportByName(String name);
}
