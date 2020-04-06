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
import com.luv2code.hibernate.entity.Student;


/**
 * @author RAY-ABEL
 *
 */
public class CreateCourseAndStudentDemo {

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
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		//create a session
		Session session =factory.getCurrentSession();
	
		try {
			session.beginTransaction();
        Course tempCourse = new Course("aikkooflogy");
			
			
			
			Student joo = new Student("yyono","sam","ray@gmail.com");
			Student boo = new Student("bojnmo","peter","booPeter@gmail.com");
			
			tempCourse.addStudent(joo);
			tempCourse.addStudent(boo);
			
			session.save(joo);
			session.save(boo);
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
