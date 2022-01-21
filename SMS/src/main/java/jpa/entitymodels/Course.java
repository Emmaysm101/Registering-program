package jpa.entitymodels;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="id")
	private int cId;
	
	@Column(name="name")
	private String cName;
	
	@Column(name="instructor")
	private String cInstructorName;
	
//	@ManyToOne(cascade= {CascadeType.PERSIST})
//	@JoinColumn(name="Student_Email")
//	private Student student;

	public Course() {
		
	}

	public Course(int id, String name, String instructor) {
		super();
		this.cId = id;
		this.cName = name;
		this.cInstructorName = instructor;
	}

	public int getId() {
		return cId;
	}

	public void setId(int id) {
		this.cId = id;
	}

	public String getName() {
		return cName;
	}

	public void setName(String name) {
		this.cName = name;
	}

	public String getInstructor() {
		return cInstructorName;
	}

	public void setInstructor(String instructor) {
		this.cInstructorName = instructor;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	
	@Override
	public String toString() {
		return "Course [id=" + cId + ", title=" + cName + ", instructor=" + cInstructorName + "]";
	}
	
}
