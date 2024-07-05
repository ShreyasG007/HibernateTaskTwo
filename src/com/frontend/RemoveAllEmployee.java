package com.frontend;

import com.controller.EmployeeController;

public class RemoveAllEmployee {
	public static void main(String[] args) {
		EmployeeController controller = new EmployeeController();
		String msg = controller.removeAllEmployee();
		System.out.println(msg);
	}
}
