package com.project.EsportSchedule.data;

import java.util.List;
import com.project.EsportSchedule.models.Event;

public interface IEventsDAO {
	public List<Event> getAllEvents();
	public List<Event> getAllEventsByDate(int date, String ids);
}
