package com.rishab.advhib;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NamedQuery {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q = s.getNamedQuery("HQL_GET_EMPLOYEE_BY_ID");
		q.setInteger("empno", 2);
		Employee e = (Employee)q.uniqueResult();
		System.out.println(e.toString());
	}
}
