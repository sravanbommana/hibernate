package com.java.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_address")
public class Student {
	@Id
	@Column(name="address_id")
	private int id;
	private String name;
	private String city;
	private Certificate cerificate;
	public Student() {

	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	public Certificate getCerificate() {
		return cerificate;
	}

	public void setCerificate(Certificate cerificate) {
		this.cerificate = cerificate;
	}
	
	
}
