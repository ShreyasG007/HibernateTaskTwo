package com.frontend;

import com.controller.EmployeeController;
import com.entity.Employee;

public class AddEmployee {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1, "rani", "dev", "rani@gmail.com",11000.00,43,27);
		Employee e2 = new Employee(2 ,"raj", "test", "raj@gmail.com",21000.00,33,17);
		Employee e3 = new Employee(3, "radha", "test", "radha@gmail.com",26000.00,38,21);
		Employee e4 = new Employee(4, "raj", "dev", "raj12@gmail.com",51000.00,32,12);
		Employee e5 = new Employee(5, "john", "dev", "john@gmail.com",51000.00,39,27);
		
		e1.setBranch_location("Pune");
		e2.setBranch_location("Mumbai");
		e3.setBranch_location("pune");
		e4.setBranch_location("delhi");
		e5.setBranch_location("pune");
		
		
		EmployeeController controller = new EmployeeController();
		controller.addEmployee(e1);
		controller.addEmployee(e2);
		controller.addEmployee(e3);
		controller.addEmployee(e4);
		controller.addEmployee(e5);
		
		controller.getEmployee();

	}

}
