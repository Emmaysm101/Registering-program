package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name="email")
	private String sEmail;
	
	@Column(name="name")
	private String sName;
	
	@Column(name="password")
	private String sPass;
	
	@OneToMany(targetEntity=Course.class, cascade= {CascadeType.PERSIST})
	private List<Course> sCourses;

	public Student() {
		
	}

	public Student(String email, String name, String password) {
		super();
		this.sEmail = email;
		this.sName = name;
		this.sPass = password;
	}

	public String getEmail() {
		return sEmail;
	}

	public void setEmail(String email) {
		this.sEmail = email;
	}

	public String getName() {
		return sName;
	}

	public void setName(String name) {
		this.sName = name;
	}

	public String getPassword() {
		return sPass;
	}

	public void setPassword(String password) {
		this.sPass = password;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	
	public void add(Course tempCourse) {
		
		if (sCourses == null) {
			sCourses = new ArrayList<>();
		}
		
		sCourses.add(tempCourse);
		
		//tempCourse.setStudent(this);
	}
	
}
