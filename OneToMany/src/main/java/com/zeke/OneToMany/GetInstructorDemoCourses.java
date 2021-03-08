package com.zeke.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDemoCourses {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		    		session.beginTransaction();
					// get the instructor from db
		    		int theId = 1;
		    		Instructor tempInstructor = session.get(Instructor.class, theId);
		    		//create some courses
		    		
		    		//get courses for instructor
		    		
		    		System.out.println(tempInstructor.getCoursers().toString());
					
					session.getTransaction().commit();
					
					
				} finally {
					// add clean up code
					session.close();
					factory.close();
				}
	}
}
