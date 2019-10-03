package com.rishab.advhib;


import java.util.List;

public class MainApplication {
	public static void main(String[] args) {
		List<Employee> empList= new EmployeeCrud().showEmploy();
		for (Employee employee : empList) {
			System.out.println(employee);
			System.out.println("===================================================");
			
		}
	}
}
