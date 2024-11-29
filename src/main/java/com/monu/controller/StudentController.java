
package com.monu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monu.entity.Student;
import com.monu.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController
{
	@Autowired
    private StudentService service;
    
	@PostMapping("/save")
	public ResponseEntity<String> saveStudentData(@RequestBody Student student)
	{
		service.saveStudent(student);
		return new ResponseEntity<>("Data Save Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Student> findStudent(@PathVariable Integer id)
	{
	Student stud = service.findStudentById(id);
	return new ResponseEntity<>(stud,HttpStatus.OK);
		
	}
	@GetMapping("/findAll")
	public List<Student> findAll()
	{
		return service.findAllStudent();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updated(@PathVariable Integer id, @RequestBody Student stud)
	{
	String s = service.studentUpdate(id,stud);
	return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
		
	}
//	@DeleteMapping("/deleteAll")
//	public String deleteAll()
//	{
//		service.deleteAllStudent();
//		return "Delete All Product";
//	}
	
	@DeleteMapping("/{id}")
	public void DeleteStud(@PathVariable int id)
	{
		service.deleteById(id);
	}	
}

