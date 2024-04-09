package com.java.hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	private String name;
	@Id
	private int empId;
	@OneToMany(mappedBy = "employee")
	private List<BankAccount> account;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BankAccount> getAccount() {
		return account;
	}

	public void setAccount(List<BankAccount> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", account=" + account + "]";
	}
	
}
