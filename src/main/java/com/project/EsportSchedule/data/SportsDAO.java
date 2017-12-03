package com.project.EsportSchedule.data;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.project.EsportSchedule.models.Sport;

public class SportsDAO implements ISportsDAO {
	private JdbcTemplate jdbc;
	
	@Autowired
	public SportsDAO(DataSource sorce) {
		jdbc = new JdbcTemplate(sorce);
	}
	
	@Override
	public List<Sport> getAllSports() {
		String sql = "SELECT * FROM sports";
		List<Sport> foundSports = jdbc.query(sql,new SportsRowMapper());
		return foundSports;
	}

	@Override
	public Sport getSportById(int id) {
		String sql = "SELECT * FROM sports WHERE sport_id=" + id;
		Sport foundSport = jdbc.query(sql, new SportsExtractor());
		return foundSport;
	}

	@Override
	public Sport getSportByName(String name) {
		String sql = "SELECT * FROM sports WHERE sport_name='" + name + "'";
		Sport foundSport = jdbc.query(sql,  new SportsExtractor());
		return foundSport;
	}
}
