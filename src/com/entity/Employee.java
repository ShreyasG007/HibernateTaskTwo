package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String ename;
	private String profile;
	private String email;
	private double Salary;
	private int age;
	private int experience;
	private String branch_location;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(int id, String ename, String profile, String email, double salary, int age, int experience) {
		super();
		this.id = id;
		this.ename = ename;
		this.profile = profile;
		this.email = email;
		Salary = salary;
		this.age = age;
		this.experience = experience;
	}

	


	public String getBranch_location() {
		return branch_location;
	}


	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getSalary() {
		return Salary;
	}


	public void setSalary(double salary) {
		Salary = salary;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", profile=" + profile + ", email=" + email + ", Salary="
				+ Salary + ", age=" + age + ", experience=" + experience + ", branch_location=" + branch_location + "]";
	}


	
	
	
	
}
