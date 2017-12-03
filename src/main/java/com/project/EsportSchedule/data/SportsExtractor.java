package com.project.EsportSchedule.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.project.EsportSchedule.models.Sport;

public class SportsExtractor implements ResultSetExtractor<Sport> {

	@Override
	public Sport extractData(ResultSet rs) throws SQLException, DataAccessException {
		Sport s = new Sport();
		
		if(rs.next())
		{
			s.setId(rs.getInt("sport_id"));
			s.setName(rs.getString("sport_name"));
			return s;
		}
		else
		{
			s.setValid(false);
			return s;
		}
	}
}
