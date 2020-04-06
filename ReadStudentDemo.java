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
public class ReadStudentDemo {

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
			
			
			System.out.println(tempStudent);
			System.out.println();
			session.save(tempStudent);
			System.out.println("done");
			
			
			
			session.getTransaction().commit();
			//new code
			//find out the student primary key
			System.out.println(tempStudent);
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class,tempStudent.getId());
			session.save(myStudent);
			session.getTransaction().commit();
			System.out.println(myStudent);
			
			
			
		}
		finally {
			factory.close();
		}

		
		
	}



	}

