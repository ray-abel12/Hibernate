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
import com.luv2code.hibernate.entity.Review;


/**
 * @author RAY-ABEL
 *
 */
public class GetCoursesReviewDemo {

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
				                .addAnnotatedClass(Review.class)
				                .buildSessionFactory();
		//create a session
		Session session =factory.getCurrentSession();
	
		try {
			session.beginTransaction();
			int theId =10;
			Course theCourse = session.get(Course.class, theId);
			System.out.println(theCourse.getReviews());
			
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
