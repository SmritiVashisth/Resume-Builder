package com.example.resumebuilder;

public class ExtraCurriculars {

	String title, decription;
	int from, to;

	public ExtraCurriculars() {
	}

	public ExtraCurriculars(String title, String description, int from, int to) {
		this.title = title;
		this.decription = description;
		this.from = from;
		this.to = to;
	}

	public String getTitle() {
		return this.title;
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

	public void setTitle(String string) {
		this.title = string;
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
