package com.usermgt.model;

public class User {
	private int id;
	private String name;
	private String contact;
	private String email;
	private String address;
	private String possition;
	
	public User() {
	} 
	
	//Parameterized Constructor
	public User(int id, String name, String contact, String email, String address, String possition) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.possition = possition;
	}
	
	//Constructor without Id
	public User(String name, String contact, String email, String address, String possition) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.possition = possition;
	}

	//Getters and Setters 
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPossition() {
		return possition;
	}
	public void setPossition(String possition) {
		this.possition = possition;
	}
	
	
}
