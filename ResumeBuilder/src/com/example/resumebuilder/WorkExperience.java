package com.example.resumebuilder;

public class WorkExperience {
	String position, place, decription;
	int from, to;

	public WorkExperience() {
	}

	public WorkExperience(String position, String place, String description,
			int from, int to) {
		this.position = position;
		this.place = place;
		this.decription = description;
		this.from = from;
		this.to = to;
	}

	public String getPosition() {
		return this.position;
	}

	public String getPlace() {
		return this.place;
	}

	public String getDescription() {
		return this.decription;
	}

	public int getFrom() {
		return this.from;
	}

	public int getTo() {
		return this.to;
	}

	public void setPosition(String string) {
		this.position = string;
	}

	public void setPlace(String string) {
		this.place = string;
	}

	public void setDescription(String string) {
		this.decription = string;
	}

	public void setFrom(int val) {
		this.from = val;
	}

	public void setTo(int val) {
		this.to = val;
	}

}
