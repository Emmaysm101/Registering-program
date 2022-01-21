package jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;




public class CourseService implements CourseDAO{
	Session session;

	public CourseService(Session session) {
		this.session = session;
	}
	
	@Override
	public List<Course> getAllCourses() {
		return session.createQuery("Select c from Course c", Course.class).getResultList();
	}

	public Course getCourseById(int id) {
		String temp = "Select c from Course c where cId =" +id;
		return session.createQuery(temp, Course.class).getSingleResult();

	}


}
