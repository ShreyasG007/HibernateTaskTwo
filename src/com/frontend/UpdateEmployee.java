package com.frontend;

import com.controller.EmployeeController;

public class UpdateEmployee {

	public static void main(String[] args) {
		
		EmployeeController controller = new EmployeeController();
		String msg=controller.updateEmployee();
		System.out.println(msg);
	}

}
