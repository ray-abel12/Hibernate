/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


/**
 * @author RAY-ABEL
 *
 */
public class CreateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory =new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Instructor.class)
				                .addAnnotatedClass(InstructorDetail.class)
				                .buildSessionFactory();
		//create a session
		Session session =factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = new Instructor("abel","ray","raybaba89@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/abel","coding");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
		    System.out.println("done saved to database");
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
