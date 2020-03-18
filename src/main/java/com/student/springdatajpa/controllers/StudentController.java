package com.student.springdatajpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.springdatajpa.entity.Student;
import com.student.springdatajpa.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public List<Student> getStudentList() {
		return studentRepo.findAll();
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") long id) {
		LOGGER.info("Finding product by ID: "+ id);
		LOGGER.info(studentRepo.findById(id).get().toString(), "test");
		return studentRepo.findById(id).get();
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public Student editStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") long id) {
		studentRepo.deleteById(id);
	}

}
