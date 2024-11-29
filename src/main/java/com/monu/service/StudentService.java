package com.monu.service;

import java.util.List;

import com.monu.entity.Student;

public interface StudentService 
{
   public String saveStudent(Student student);
   public Student findStudentById(Integer id);
   public List<Student> findAllStudent();
   public String studentUpdate(Integer id,Student stud);
  // void deleteAllStudent();
   public void deleteById(Integer id);
   
}







