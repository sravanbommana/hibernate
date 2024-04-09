package com.java.hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	private String projectName;
	@ManyToMany
//	@JoinTable
//	(
//		name="emp_project",
//		joinColumns = { @JoinColumn(name ="eid")},
//		inverseJoinColumns = { @JoinColumn(name="pid")}
//	)
	private List<EmployeeOne> employee;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<EmployeeOne> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeOne> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projectName=" + projectName + ", employee=" + employee + "]";
	}

}
