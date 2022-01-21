package jpa.service;




import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


import jpa.entitymodels.Course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class CourseServiceTest {

	@Test
	public void getAllCourses() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		CourseService courseService = new CourseService(session);
		session.beginTransaction();
		List<Course> allCourses = courseService.getAllCourses();
		assertEquals(10,allCourses.size());
		session.close();
		factory.close();
	}
}
