package com.project.EsportSchedule.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.project.EsportSchedule.models.Event;

public class EventsRowMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int idx) throws SQLException {
		Event e = new Event();
		e.setId(rs.getInt("id"));
		e.setLeagueName(rs.getString("leagueName"));
		e.setEsportName(rs.getString("esportName"));
		e.setTeamOne(rs.getString("teamOne"));
		e.setTeamTwo(rs.getString("teamTwo"));
		e.setStartDate(rs.getTimestamp("eventTime"));
		return e;
	}

}
