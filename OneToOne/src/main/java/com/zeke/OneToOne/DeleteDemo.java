package com.zeke.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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
		
    		//start transaction
    		session.beginTransaction();
    		
    		// get instructor by primary key / id
    		int theId = 1;
    		Instructor tempInstructor = session.get(Instructor.class, theId);
    		
    		System.out.println("Instructor to delete "+tempInstructor);
    		
    		//delete instructor will also delete detail instructor
    		if(tempInstructor !=null) {
    			session.delete(tempInstructor);
    		}
    		
    		//commit;
    		session.getTransaction().commit();
    		
    		
		} finally {
			factory.close();
		}
    }
}
