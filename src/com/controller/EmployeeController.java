package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	EmployeeService service = new EmployeeService();
	
	public void getEmployee() {
		service.getEmployee();
	}
	
	public String addEmployee(Employee e) {
		return service.addEmployee(e);
	}

	public void sumOfSalary() {
		service.sumOfSalary();
		
	}

	public void maxSalaryTestProfile() {
		service.maxSalaryTestProfile(); 
		
	}

	public void avgExperience() {
		service.avgExperience();
		
	}

	public void getHighestPaidEmployee() {
		service.getHighestPaidEmployee();
		
	}

	public void getLowestPaidEmployee() {
		service.getLowestPaidEmployee();
		
	}

	public void getCountOfEmployee() {
		service.getCountOfEmployee();
		
	}

	public void getTestSalaryHavingMoreThanTwentyFiveK() {
		service.getTestSalaryHavingMoreThanTwentyFiveK();
		
	}

	public String updateEmployee() {
		 return	service.updateEmployee();
		
	}

	public void getSecondHighestPaidEmployee() {
		service.getSecondHighestPaidEmployee();
		
	}

	public void getSecondLowestPaidEmployee() {
		service.getSecondLowestPaidEmployee();
		
	}

	public void getAvgSalaryDevProfile() {
		service.getAvgSalaryDevProfile();
		
	}

	public void getLowestExperience() {
		service.getLowestExperience();
		
	}
	
	public void getEmployeeWithLowestAgeAndMaxSalary() {
		service.getEmployeeWithLowestAgeAndMaxSalary();
	}

	public String removeAllEmployee() {
		return service.removeAllEmployee();
		
	}

	
}
