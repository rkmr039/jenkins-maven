package com.rishab.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EmployeeSorting {

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<Employee>();
		
		emps.add(new Employee(1,"A"));
		emps.add(new Employee(6,"B"));
		emps.add(new Employee(5,"B"));
		emps.add(new Employee(4,"D"));
		emps.add(new Employee(2,"F"));
		emps.add(new Employee(7,"G"));
		emps.add(new Employee(3,"C"));
		emps.add(new Employee(8,"H"));
		
		
		
		EmployeeComparator comparator = new EmployeeComparator();
		
		
		System.out.println("Before Sorting ");
		emps.stream().forEach(emp -> System.out.println(emp.toString()));
		
		
	
		System.out.println();
		System.out.println("After Sorting ");
		Collections.sort(emps, comparator);
		
		emps.stream().forEach(emp -> System.out.println(emp.toString()));
		
		/*
		 * Map<Integer, String> emps = new HashMap<Integer, String>();
		 * 
		 * emps.put(1, "A"); emps.put(2, "B"); emps.put(5, "C"); emps.put(4, "D");
		 * emps.put(6, "E"); emps.put(3, "F");
		 * 
		 * Properties properties = new Properties(); properties.putAll(emps);
		 * 
		 * properties.forEach((a,b) -> { System.out.println();
		 * 
		 * });
		 */
		
	}

}
