package com.project.EsportSchedule.data;

import java.util.List;
import com.project.EsportSchedule.models.Sport;

public interface ISportsDAO {
	public List<Sport> getAllSports();
	public Sport getSportById(int id);
	public Sport getSportByName(String name);
}
