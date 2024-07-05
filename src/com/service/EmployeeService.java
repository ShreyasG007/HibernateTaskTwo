package com.service;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeService {
	EmployeeDao dao= new EmployeeDao();
	
	public void getEmployee() {
		dao.getEmployees();
	}
	
	public String addEmployee(Employee e) {
		
		dao.addEmployee(e);
		
		if(true) {
			return "Employee added Sucessfully";	
		} else
			return "Employee not added";
		
	}

	public void sumOfSalary() {
		dao.sumOfSalary();
		
	}

	public void maxSalaryTestProfile() {
		dao.maxSalaryTestProfile(); 
	}

	public void avgExperience() {
		dao.avgExperience();
		
	}

	public void getHighestPaidEmployee() {
		dao.getHighestPaidEmployee();
		
	}

	public void getLowestPaidEmployee() {
		dao.getLowestPaidEmployee();
		
	}

	public void getCountOfEmployee() {
		dao.getCountOfEmployee();
		
	}

	public void getTestSalaryHavingMoreThanTwentyFiveK() {
		dao.getTestSalaryHavingMoreThanTwentyFiveK();
		
	}

	public String updateEmployee() {
		dao.updateEmployee();
		
		if(true) {
			return "Employee Updated Successfully";
		}
		else {
			return "not updated";
		}
	}

	public void getSecondHighestPaidEmployee() {
		dao.getSecondHighestPaidEmployee();
		
	}

	public void getSecondLowestPaidEmployee() {
		dao.getSecondLowestPaidEmployee();
	}

	public void getAvgSalaryDevProfile() {
		dao.getAvgSalaryDevProfile();
	}

	public void getLowestExperience() {
		dao.getLowestExperience();
		
	}
	
	public void getEmployeeWithLowestAgeAndMaxSalary() {
		dao.getEmployeeWithLowestAgeAndMaxSalary();
	}

	public String removeAllEmployee() {
		
		dao.removeAllEmployee();
		if(true) {
			return "remove all employees";
		}
		else {
			return "All employees not rempved";
		}
	}
}
