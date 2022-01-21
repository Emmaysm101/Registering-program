package jpa.service;

import java.util.List;
import org.hibernate.Session;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;


public class StudentService implements StudentDAO {
	Session session;
	
	public StudentService(Session session) {
		this.session = session;
	}
	
	@Override
	public List<Student> getAllStudent() {
		return session.createQuery("Select s from Student s", Student.class).getResultList();
		
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		String temp = "Select s from Student s where email =" +"'"+sEmail+"'";
		return session.createQuery(temp, Student.class).getSingleResult();
	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		Student s = getStudentByEmail(sEmail);
		if (s == null) {
			return false;
		}else {
			if (s.getPassword().equals(sPassword)) {
				return true;
			}else {
				return false;
			}
		}
		
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		try {
			Student s = getStudentByEmail(sEmail);
			List<Course> studentCourses = getStudentCourses(sEmail);
			boolean checkRegister = studentCourses.stream().anyMatch(course -> course.getId() == cId);
			if (checkRegister) {
				System.out.println("You are already registered in that course!");
			} else {
				CourseService cs = new CourseService(session);
				Course tempCourse = cs.getCourseById(cId);
				s.add(tempCourse);

			}
		}catch (Exception e) {
			System.out.println("Exception occurred");
			throw e;
		}
		
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		Student s = getStudentByEmail(sEmail);
		if (s == null) {
			return null;
		}else {
			return s.getsCourses();
		}
		
	}
	
}
