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
public class DeleteDemo {

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
			
			session.beginTransaction();
			
			int theId = 1999;
			Instructor tempInstructor = session.get(Instructor.class, theId);
		   
			System.out.println("the id is "+ tempInstructor.getId());
			
			if(tempInstructor !=null) {
				
				session.delete(tempInstructor);
				System.out.println("deleted");
				
			}
			
			System.out.println("error connection closed");
			session.getTransaction().commit();
			 System.out.println("done");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
