package com.example.resumebuilder;

import android.app.Application;

public class Global extends Application {

	static String personName = null;
	static String birthday = null;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
