/**
 * 
 */
package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

/**
 * @author RAY-ABEL
 *
 */
public class QueryStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			List<Student> myStudent =session.createQuery("from Student").list();
			
			for(Student index:myStudent) {
				System.out.println(index);
			}
			
			//commit student object to database
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
