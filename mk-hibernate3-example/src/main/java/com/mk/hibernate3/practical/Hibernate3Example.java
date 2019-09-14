package com.mk.hibernate3.practical;

import java.util.Date;

import org.hibernate.Session;

import com.mk.hibernate3.practical.bean.EmployeeBean;
import com.mk.hibernate3.practical.util.Hibernate3Util;

public class Hibernate3Example {
	public static void main(String[] args) {
		System.out.println("Hibernate 3 Practical start");
		Session session = Hibernate3Util.getSessionFactory().openSession();
		session.beginTransaction();
		EmployeeBean employeeBean = new EmployeeBean();
					 employeeBean.setEmployeeId(1342);
					 employeeBean.setFirstName("Employee2");
					 employeeBean.setLastName("Employee2LastName");
					 employeeBean.setGender('M');
					 employeeBean.setContactNumber("99999999");
					 employeeBean.setEmail("hello3@gmail.com");
					 employeeBean.setAddress("Madiwalla,Bangalore,560067");
					 employeeBean.setZipcode(560067);
					 employeeBean.setSalary(53434.43);
					 employeeBean.setDescription("Employee description");
					 employeeBean.setStatus(Boolean.TRUE);
					 employeeBean.setCreateDate(new Date());
					 employeeBean.setUpdateDate(new Date());
					 session.save(employeeBean);
				     session.getTransaction().commit();
		System.out.println("Hibernate 3 Practical End");
	}
}
