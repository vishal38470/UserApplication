package com.tcs.UserApplication.HelloWorldBean;

public class HelloWorldBean {

	private String firstname;
	private String lastname;
	private String city;
	@Override
	public String toString() {
		return "HelloWorldBean [firstname=" + firstname + ", lastname=" + lastname + ", city=" + city + "]";
	}
	public HelloWorldBean(String firstname, String lastname, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
