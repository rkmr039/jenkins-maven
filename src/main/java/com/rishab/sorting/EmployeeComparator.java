package com.rishab.sorting;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		int nameCompareResult =  o1.getName().compareTo(o2.getName());
		int idCompareResult = compareIds(o1.getId(),o2.getId());
		if(nameCompareResult == 0) {
			  return idCompareResult;
		} return nameCompareResult;
	}
	
	public int compareIds(int id1, int id2) {
		if(id1 > id2) return 1;
		else if(id1 < id2) return -1;
		else return 0;
	}

}
