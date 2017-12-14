package com.project.EsportSchedule.data;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.project.EsportSchedule.models.Event;

@Component
public class EventsDAO implements IEventsDAO {
	private JdbcTemplate jdbc;
	private final String SELECT_EVENTS = "SELECT e.id AS id,e.event_time AS eventTime,s.name AS esportName,l.name AS leagueName,t1.name AS teamOne,t2.name AS teamTwo "
			+ "FROM events e "
			+ "JOIN leagues l ON e.id_league = l.id AND l.deleted = 0 "
			+ "JOIN esports s ON e.id_esport = s.id AND s.deleted = 0 "
			+ "JOIN teams t1 ON e.id_team_one = t1.id AND t1.deleted = 0 "
			+ "JOIN teams t2 ON e.id_team_two = t2.id AND t2.deleted = 0 "
			+ "WHERE e.deleted = 0 ";
	
	public EventsDAO(DataSource sorce) {
		jdbc = new JdbcTemplate(sorce);
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> allEvents;
		String sql = SELECT_EVENTS
				+ "ORDER BY e.event_time ASC";
		allEvents = jdbc.query(sql, new EventsRowMapper());
		return allEvents;
	}

	@Override
	public List<Event> getAllEventsByDate(int date, String ids) {
		List<Event> allEvents;
		String dateString = Integer.toString(date);
		String sql = SELECT_EVENTS;
				if(dateString.length() == 4) {
					sql += "AND DATE_FORMAT(e.event_time, '%Y') = '" + date + "' ";
				} else if(dateString.length() == 6) {
					sql += "AND DATE_FORMAT(e.event_time, '%Y%m') = '" + date + "' ";
				} else if(dateString.length() == 8) {
					sql += "AND DATE_FORMAT(e.event_time, '%Y%m%d') = '" + date + "' ";
				}
				
				if(ids != null) {
					sql += "AND e.id_esport IN(" + ids + ")";
				}
				sql += "ORDER BY e.event_time ASC";
		allEvents = jdbc.query(sql, new EventsRowMapper());
		return allEvents;
	}
}
