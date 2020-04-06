/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


/**
 * @author RAY-ABEL
 *
 */
public class GetCoursesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory =new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Instructor.class)
				                .addAnnotatedClass(InstructorDetail.class)
				                .addAnnotatedClass(Course.class)
				                .buildSessionFactory();
		//create a session
		Session session =factory.getCurrentSession();
		int theId=1;
		try {
			session.beginTransaction();
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("instructor is "+tempInstructor);
			System.out.println("course offered are "+ tempInstructor.getCourse());
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
