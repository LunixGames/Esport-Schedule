package com.project.EsportSchedule.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.EsportSchedule.data.ISportsDAO;
import com.project.EsportSchedule.models.Sport;

@Service
public class EsportService implements IEsportService {

	private ISportsDAO database;
	
	@Autowired
	public EsportService(ISportsDAO sportsDao) {
		database = sportsDao;
	}
	
	@Override
	public ResponseEntity<?> getAllSports() {
		List<Sport> allSports = database.getAllSports();
		
		if(allSports == null || allSports.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Sport>>(allSports, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getSportById(int id) {
		Sport foundSport = database.getSportById(id);
		
		if(!foundSport.isValid())
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				
		return new ResponseEntity<Sport>(foundSport, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getSportByName(String name) {
		Sport foundSport = database.getSportByName(name);
		
		if(!foundSport.isValid())
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Sport>(foundSport, HttpStatus.OK);
	}

}
