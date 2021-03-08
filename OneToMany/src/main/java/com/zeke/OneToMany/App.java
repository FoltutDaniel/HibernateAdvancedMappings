package com.zeke.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	//create session factory
    	SessionFactory factory = new Configuration()
    							.configure("hibernate.cfg.xml")
    							.addAnnotatedClass(Instructor.class)
    							.addAnnotatedClass(InstructorDetail.class)
    							.addAnnotatedClass(Course.class)
    							.buildSessionFactory();
    	
    	//create a session
    	
    	Session session = factory.getCurrentSession();
    	
    	try {
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@zeke.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/Suspub","Gamer");
			 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			
		} finally {
			// add clean up code
			
			factory.close();
		}
    }
}
