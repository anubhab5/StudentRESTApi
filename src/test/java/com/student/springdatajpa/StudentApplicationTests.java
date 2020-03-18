package com.student.springdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.springdatajpa.entity.Student;
import com.student.springdatajpa.repository.StudentRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentApplicationTests {

	@Autowired
	private StudentRepository studentRepo;

	@Test
	void contextLoads() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Anubhab");
		student.setTestmarks(99);
		studentRepo.save(student);

		Student savedStudent = studentRepo.findById(1l).get();

		assertNotNull(savedStudent);
		studentRepo.delete(student);
	}

}
