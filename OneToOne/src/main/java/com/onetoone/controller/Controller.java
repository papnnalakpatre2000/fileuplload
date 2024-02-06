package com.onetoone.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onetoone.entity.Courses;
import com.onetoone.entity.Student;
import com.onetoone.repository.DaoCourse;
import com.onetoone.repository.DaoStudent;
import com.onetoone.uploadedfilehandler.UploadedFileHandler;

@RestController
public class Controller {
	
	@Autowired
	public DaoStudent daostudent;
	
	@Autowired
	public DaoCourse daocourse;
	
	@Autowired
	public UploadedFileHandler fileHandler;
	
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadtheFile(@RequestParam("file") MultipartFile file){
		
		if(file.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("File is empty");
		}
		
		try {
			String s=fileHandler.upload(file);
			
			
			return ResponseEntity.ok(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not able to Upload the file!");
	}
	
	
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		List<Student> list=daostudent.findAll();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<Courses>> getAllcourses(){
		
		List<Courses> list=daocourse.findAll();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student s)
	{
		
		try {
			Student ss=daostudent.save(s);
			return ResponseEntity.of(Optional.of(ss));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		
		try {
			Student s=daostudent.findById(id).get();
			return ResponseEntity.ok().body(s);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Courses> getcourseById(@PathVariable int id){
		
		try {
			Courses s=daocourse.findById(id).get();
			return ResponseEntity.ok().body(s);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	

}
