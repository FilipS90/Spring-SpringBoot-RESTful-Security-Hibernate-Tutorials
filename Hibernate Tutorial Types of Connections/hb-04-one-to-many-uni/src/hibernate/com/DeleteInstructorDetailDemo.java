package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int id = 7;
			session.beginTransaction();
			
			Instructor temp = 
					session.get(Instructor.class, id);
			
			temp.getInstructorDetail().setInstructor(null);;
			
			session.delete(temp);
			
			
			session.getTransaction().commit();
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
