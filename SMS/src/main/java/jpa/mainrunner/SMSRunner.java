package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();


		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			Scanner scanner = new Scanner(System.in);
			StudentService ss = new StudentService(session);
			CourseService cs = new CourseService(session);
			int userInput;
			
			do {
				System.out.println("Are you a(n) \n 1.Student \n 2.Quit");
				System.out.println("Please enter 1 or 2");
				userInput = scanner.nextInt();
				
				
				if (userInput == 1) {
					System.out.println("Enter you Email: ");
					String eamilString = scanner.next();
					System.out.println("Enter your password: ");
					String passString = scanner.next();
					boolean login = ss.validateStudent(eamilString, passString);
					
					
					if (login) {
						System.out.println("My Classes: ");
						System.out.println("# CourseName   InstructorName");
						List<Course> courseList = ss.getStudentCourses(eamilString);
						for (int i=0; i<courseList.size(); i++) {
							System.out.println(courseList.get(i).getId() + " " +
									courseList.get(i).getName() + " " + courseList.get(i).getInstructor());
						}
						
						System.out.println("1. Register to class \n2. Logout");
						userInput = scanner.nextInt();
						if (userInput == 1 ) {
							List<Course> allCourse = cs.getAllCourses();
							System.out.println("All Courses: ");
							System.out.println("Id  CourseName  InstructorName");
							for (int i=0; i<allCourse.size(); i++) {
								System.out.println(allCourse.get(i).getId() + "  " +
										allCourse.get(i).getName() + "  " + allCourse.get(i).getInstructor());
							}
							
							System.out.println("Which Course?");
							int courseN = scanner.nextInt();
							ss.registerStudentToCourse(eamilString, courseN);
							List<Course> finalCourseList = ss.getStudentCourses(eamilString);
							System.out.println("My Classes: ");
							System.out.println("# CourseName   InstructorName");
							for (int i=0; i<finalCourseList.size(); i++) {
								System.out.println(finalCourseList.get(i).getId() + " " +
										finalCourseList.get(i).getName() + " " + finalCourseList.get(i).getInstructor());
							}
						}
						
					}else {
						System.out.println("Invalid id or password");
					}
					
				}
			}while (userInput != 2);
			System.out.println("You have been signed out.");
				
				
			

			
//			List<Student> list = ss.getAllStudent();
//			for (int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).getName());
//			}
//			
//			Student s = ss.getStudentByEmail("aiannitti7@is.gd");
//			System.out.println(s.getEmail());
//			System.out.println(s.getName());
			
			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			// add clean up code
			session.close();

			factory.close();
		}

	}

}
