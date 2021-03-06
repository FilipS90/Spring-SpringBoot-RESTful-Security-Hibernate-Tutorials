package hibernate.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.entity.Course;
import hibernate.com.entity.Instructor;
import hibernate.com.entity.InstructorDetail;
import hibernate.com.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int cId = 17;
			
			
			Course course = session.get(Course.class, cId);
			session.delete(course);
						
			session.getTransaction().commit();
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
