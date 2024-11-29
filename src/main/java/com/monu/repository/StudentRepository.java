package com.monu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
