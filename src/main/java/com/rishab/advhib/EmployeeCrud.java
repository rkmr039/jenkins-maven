package com.rishab.advhib;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeCrud {
	
	public  String updateEmploy(Employee e) {
		Employee res = searchEmployee(e.getEmpno());
		res.setName(e.getName());
		res.setDept(e.getDept());
		res.setDesig(e.getDesig());
		res.setBasic(e.getBasic());
		
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Transaction t = s.getTransaction();
		s.update(res);
		t.begin();
		t.commit();
		return "******UPDATED SUCCESFULLY*****";
	}
	
	public List<Employee> showEmploy() {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee");
		List<Employee> empList = q.list();
		return empList;
	}
	public  Employee searchEmployee(int empno) {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee where empno = "+empno);
		List<Employee> lstEmployee = q.list();
		Employee e = null;
		if(lstEmployee.size() != 0) {
			e = lstEmployee.get(0);
		}
		return e;
	}
	public  boolean insertEmployee(Employee e) {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		boolean flag = false;
		int empno = 0;
		Query q =  s.createQuery("SELECT max(empno) from Employee");
		for(Iterator it = q.iterate(); it.hasNext();) {
			empno = (Integer)it.next();
		}
		empno++;
		e.setEmpno(empno);
		s.save(e);
		Transaction t = s.getTransaction();
		t.begin();
		t.commit();
		flag = true;
		return flag;
	}

	public String removeEmploy(int empno) {
		Employee res = searchEmployee(empno);
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		s.delete(res);
		Transaction t = s.getTransaction();
		t.begin();
		t.commit();
		return "***DELETED***";
	}
	
	public static void main(String[] args) {
		/*List<Employee> empList= new EmployeeCrud().showEmploy();
		for (Employee employee : empList) {
			System.out.println(employee);
		}*/
		
		SessionFactory sf = HibernateUtil.getConnection();
		Session session = sf.openSession();
		Query q = session.createQuery("from Employee");
		
		// q.setFirstResult(2);
		// q.setMaxResults(3);
		// List<Employee> empList = q.list();
		
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("basic", 45000));
	    criteria.addOrder(Order.asc("basic"));
	    
	 
		List<Employee> empList = criteria.list();
		
		for (Employee employee : empList) {
			System.out.println(employee.toString());
		}
		
		Projection p = Projections.property("desig");
		criteria.setProjection(p);
		List<String> result = criteria.list();
		
		for (String string : result) {
			System.out.println(string);
		}
		
		q = session.getNamedQuery("HQL_GET_ALL_EMPLOYEE");
		empList = q.list();
		for (Employee employee : empList) {
			System.out.println(employee.toString());
		}
	}
}
