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
public class CreateStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory =new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		//create a session
		Session session =factory.getCurrentSession();
		
		try {
			//create  a new student object
			Student tempStudent = new Student("abel","ray","love@gmail.com");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
