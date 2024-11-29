package com.monu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monu.entity.Student;
import com.monu.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
    private StudentRepository repo;
	
	@Override
	public String saveStudent(Student student)
	{
		repo.save(student);
		return "Student Data Successfully";
	}

	@Override
	public Student findStudentById(Integer id)
	{
		Student student = null;
		
		Optional<Student> findById = repo.findById(id);
		
		if (findById.isPresent()) 
		{
			student = findById.get();
		}
		
		System.out.println(student);
		return student;
	}

	@Override
	public List<Student> findAllStudent() 
	{
		return repo.findAll();
	}

	@Override
	public String studentUpdate(Integer id, Student stud) 
	{
		Student student = repo.findById(id).get();
		student.setFirstName(stud.getFirstName());
		student.setLastName(stud.getLastName());
		student.setFees(stud.getFees());
		repo.save(student);
		return "student updated Sucessfully";
	}

//	@Override
//	public void deleteAllStudent() 
//	{
//		repo.deleteAll();
//	}

	@Override
	public void deleteById(Integer id) 
	{
		repo.deleteById(id);
	}

}
