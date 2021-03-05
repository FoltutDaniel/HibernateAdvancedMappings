package com.zeke.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class CreateDemo 
{
    public static void main( String[] args ) {
       
    	//build factory
    	SessionFactory factory = new Configuration()
    							.configure("hibernate.cfg.xml")
    							.addAnnotatedClass(Instructor.class)
    							.addAnnotatedClass(InstructorDetail.class)
    							.buildSessionFactory();
    	
    	//create session
    	Session session = factory.getCurrentSession();
    	
    	try {
			//create objects
    		Instructor tempInstructor = new Instructor("Dan", "Folt", "danfolt@zeke.com");
    		InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/ZekeAsakura","Coding");
    		
    		//Associate objects
    		tempInstructor.setInstructorDetail(tempInstructorDetail);
    		//start transaction
    		session.beginTransaction();
    		
    		//save the instructor this will save details too
    		System.out.println("Saving instructor and details");
    		session.save(tempInstructor);
    		
    		//commit;
    		session.getTransaction().commit();
    		
    		
		} finally {
			factory.close();
		}
    }
}
