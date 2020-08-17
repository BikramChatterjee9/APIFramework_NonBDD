package com.api.pojo;

public class User {
	
	public String first_name;
	public String last_name;
	public String dob;
	public String email;
	public String gender;
	public String status;
	public String address;
	public User(String first_name, String last_name, String dob, String email, String gender, String status,
			String address) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.address = address;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
