package com.project.EsportSchedule.data;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.project.EsportSchedule.models.Sport;

@Component
public class SportsDAO implements ISportsDAO {
	private JdbcTemplate jdbc;
	
	@Autowired
	public SportsDAO(DataSource sorce) {
		jdbc = new JdbcTemplate(sorce);
	}
	
	@Override
	public List<Sport> getAllSports() {
		List<Sport> foundSports;
		String sql = "SELECT * FROM esports WHERE deleted = 0 "
				+ "ORDER BY name ASC";
		foundSports = jdbc.query(sql, new SportsRowMapper());
		return foundSports;
	}

	@Override
	public Sport getSportById(int id) {
		List<Sport> foundSports;
		Sport foundSport;
		String sql = "SELECT * FROM esports WHERE id=" + id
				+ " AND deleted = 0 "
				+ "ORDER BY name ASC";
		foundSports = jdbc.query(sql, new SportsRowMapper());
		
		if(foundSports.size() > 0)
			foundSport = foundSports.get(0);
		else {
			foundSport = new Sport();
			foundSport.setId(id);
			foundSport.setValid(false);
		}
		
		return foundSport;
	}
}
