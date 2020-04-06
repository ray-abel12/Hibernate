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
public class PrimaryKeyDemo {

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
			//create student object
			System.out.print("creating 3 student object");
			Student sam = new Student("sam","bako","samBako@gmail.com");
			Student john = new Student("john","ray","johnRay@gmail.com");
			Student jane = new Student("jane","ray","janeRay@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("saving the 3 student");
			session.save(sam);
			session.save(john);
			session.save(jane);
			
			//commit student object to database
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
