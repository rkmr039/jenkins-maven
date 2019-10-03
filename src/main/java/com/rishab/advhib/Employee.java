package com.rishab.advhib;

import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
@Table (name="Employee")
@NamedQueries({@NamedQuery(name="HQL_GET_ALL_EMPLOYEE",query = "from Employee")})
public class Employee {
	
	
	private int empno;
	private String dept;
	private String name;
	private String desig;
	private int basic;
	
	@Id
	@Column(name="empno")
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	@Column(name="dept")
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="desig")
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	@Column(name="basic")
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", dept=" + dept + ", name=" + name + ", desig=" + desig + ", basic="
				+ basic + "]";
	}
	
	
	
}
