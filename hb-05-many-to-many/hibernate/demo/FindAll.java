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
public class FindAll {
	public static void main(String[] args) {
	SessionFactory factory =new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory();
//create a session
	Session session = factory.getCurrentSession();
try {
session.beginTransaction();
Course tempCourse = new Course("biology");

tempCourse.addReview(new Review("good course"));
tempCourse.addReview(new Review("beautiful"));
tempCourse.addReview(new Review("exellent"));

session.save(tempCourse);


session.getTransaction().commit();

}
finally {
session.close();
factory.close();
}

}
}
