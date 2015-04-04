package com.example.resumebuilder;

public class PersonalDetails {

	String name, email, contact, employment, father, gender, category,
			birthday, perm_addr, curr_addr;

	public PersonalDetails() {
	}

	public PersonalDetails(String name, String email, String contact_number,
			String current_employment, String father, String gender,
			String category, String birthday, String perm_addr, String curr_addr) {
		this.name = name;
		this.email = email;
		this.contact = contact_number;
		this.employment = current_employment;
		this.father = father;
		this.gender = gender;
		this.category = category;
		this.birthday = birthday;
		this.perm_addr = perm_addr;
		this.curr_addr = curr_addr;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	public String getContact() {
		// TODO Auto-generated method stub
		return this.contact;
	}

	public String getEmployment() {
		// TODO Auto-generated method stub
		return this.employment;
	}

	public String getFather() {
		// TODO Auto-generated method stub
		return this.father;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return this.category;
	}

	public String getDOB() {
		// TODO Auto-generated method stub
		return this.birthday;
	}

	public String getPermaddr() {
		// TODO Auto-generated method stub
		return this.perm_addr;
	}

	public String getCurraddr() {
		// TODO Auto-generated method stub
		return this.curr_addr;
	}

	public void setName(String person) {
		// TODO Auto-generated method stub
		this.name = person;
	}

	public void setEmail(String string) {
		// TODO Auto-generated method stub
		this.email = string;
	}

	public void setContact(String string) {
		// TODO Auto-generated method stub
		this.contact = string;
	}

	public void setEmployment(String string) {
		// TODO Auto-generated method stub
		this.employment = string;
	}

	public void setFather(String string) {
		// TODO Auto-generated method stub
		this.father = string;
	}

	public void setGender(String string) {
		// TODO Auto-generated method stub
		this.gender = string;
	}

	public void setCategory(String string) {
		// TODO Auto-generated method stub
		this.category = string;
	}

	public void setDOB(String string) {
		// TODO Auto-generated method stub
		this.birthday = string;
	}

	public void setPermaddr(String string) {
		// TODO Auto-generated method stub
		this.perm_addr = string;
	}

	public void setCurraddr(String string) {
		// TODO Auto-generated method stub
		this.curr_addr = string;
	}

}
