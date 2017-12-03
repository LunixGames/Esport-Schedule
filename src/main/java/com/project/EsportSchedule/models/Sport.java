package com.project.EsportSchedule.models;

public class Sport {
	private int id;
	private String name;
	private boolean valid;
	
	public Sport() {
		this.valid = true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
