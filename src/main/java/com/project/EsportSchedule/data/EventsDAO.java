package com.project.EsportSchedule.data;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.project.EsportSchedule.models.Event;

public class EventsDAO implements IEventsDAO {
	private JdbcTemplate jdbc;
	
	@Autowired
	public EventsDAO(DataSource sorce) {
		jdbc = new JdbcTemplate(sorce);
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> allEvents;
		String sql = "SELECT e.id AS id,e.event_time AS eventTime,s.name AS esportName,l.name AS leagueName,t1.name AS teamOne,t2.name AS teamTwo "
				+ "FROM events e "
				+ "JOIN leagues l ON e.id_league = l.id AND l.deleted = 0 "
				+ "JOIN esports s ON e.id_esport = s.id AND s.deleted = 0 "
				+ "JOIN teams t1 ON e.id_team_one = t1.id AND t1.deleted = 0 "
				+ "JOIN teams t2 ON e.id_team_two = t2.id AND t2.deleted = 0 "
				+ "WHERE e.deleted = 0 "
				+ "ORDER BY e.event_time ASC";
		allEvents = jdbc.query(sql, new EventsRowMapper());
		return allEvents;
	}

	@Override
	public List<Event> getAllEventsByDate(String date) {
		List<Event> allEvents;
		String sql = "SELECT e.id AS id,e.event_time AS eventTime,s.name AS esportName,l.name AS leagueName,t1.name AS teamOne,t2.name AS teamTwo "
				+ "FROM events e "
				+ "JOIN leagues l ON e.id_league = l.id AND l.deleted = 0 "
				+ "JOIN esports s ON e.id_esport = s.id AND s.deleted = 0 "
				+ "JOIN teams t1 ON e.id_team_one = t1.id AND t1.deleted = 0 "
				+ "JOIN teams t2 ON e.id_team_two = t2.id AND t2.deleted = 0 "
				+ "WHERE e.deleted = 0 ";
				if(date.length() < 8) {
					sql += "AND UNIX_TIMESTAMP(e.event_time) >= UNIX_TIMESTAMP('" + date + "01" + "') AND UNIX_TIMESTAMP(e.event_time) < UNIX_TIMESTAMP(DATE_ADD('" + date + "01" + "',INTERVAL 1 MONTH))";
				} else {
					sql += "AND UNIX_TIMESTAMP(e.event_time) >= UNIX_TIMESTAMP('" + date + "') AND UNIX_TIMESTAMP(e.event_time) < UNIX_TIMESTAMP(DATE_ADD('" + date + "',INTERVAL 1 DAY))";
				}
				sql += "ORDER BY e.event_time ASC";
		allEvents = jdbc.query(sql, new EventsRowMapper());
		return allEvents;
	}
}
