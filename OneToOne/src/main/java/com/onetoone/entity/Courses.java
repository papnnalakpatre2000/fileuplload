package com.onetoone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int courseId;
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	private String course5;
	
	
	@OneToOne(mappedBy = "courses")

	@JsonBackReference
	private Student student;
	
	
	
	public Courses() {
		super();
	}
	public Courses(int courseId, String course1, String course2, String course3, String course4, String course5) {
		super();
		this.courseId = courseId;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
		this.course4 = course4;
		this.course5 = course5;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourse1() {
		return course1;
	}
	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	public String getCourse2() {
		return course2;
	}
	public void setCourse2(String course2) {
		this.course2 = course2;
	}
	public String getCourse3() {
		return course3;
	}
	public void setCourse3(String course3) {
		this.course3 = course3;
	}
	public String getCourse4() {
		return course4;
	}
	public void setCourse4(String course4) {
		this.course4 = course4;
	}
	public String getCourse5() {
		return course5;
	}
	public void setCourse5(String course5) {
		this.course5 = course5;
	}
	
	
	
	
	

}
