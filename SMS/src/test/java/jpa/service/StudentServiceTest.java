package jpa.service;

import java.util.List;

import org.assertj.core.api.Assert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {
	
	
	@Test
	public void testGetStudentByEmail() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		StudentService studentService = new StudentService(session);
		session.beginTransaction();
		
		Student expected = new Student();
		expected.setEmail("aiannitti7@is.gd");
		expected.setName("Alexandra Iannitti");
		expected.setPassword("TWP4hf5j");
		Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");
		assertEquals(expected.getEmail(), actual.getEmail());
		
		session.close();
		factory.close();
	}
	

}
