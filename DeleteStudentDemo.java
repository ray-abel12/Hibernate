/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

/**
 * @author RAY-ABEL
 *
 */
public class DeleteStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int theId =2;
		try {
			
	
			session.beginTransaction();
			Student student =session.get(Student.class,theId);
			
			//delete from db
			System.out.println("deleting fom database");
			session.delete(student);
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
