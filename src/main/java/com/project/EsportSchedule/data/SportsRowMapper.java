package com.project.EsportSchedule.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.project.EsportSchedule.models.Sport;

public class SportsRowMapper implements RowMapper<Sport>{

	@Override
	public Sport mapRow(ResultSet rs, int row) throws SQLException {
		Sport s = new Sport();
		s.setId(rs.getInt("sport_id"));
		s.setName(rs.getString("sport_name"));
		return s;
	}

}
