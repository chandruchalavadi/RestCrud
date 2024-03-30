package org.jsp.RestCrud.dao;

import java.util.List;

import org.jsp.RestCrud.dto.Student;
import org.jsp.RestCrud.helper.ResponseStructure;
import org.jsp.RestCrud.repository.Myrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class Mydao {
	@Autowired
	Myrepository repository;

	public Student save(Student student) {

		return repository.save(student);
	}

	public List<Student> save(List<Student> students) {
		return repository.saveAll(students);
	}

	public List<Student> fetchAll() {

		return repository.findAll();
	}

	public Student fetchById(int id) {
		return repository.findById(id).get();
	}

	public Student fetchByName(String name) {
		return repository.findByName(name);
	}

	public Student fetchByMobile(Long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> fetchByResult(String result) {
		return repository.findByResult(result);
	}

	public List<Student> fetchByPercentageGreater(double percentage) {
		return repository.findByPercentageGreaterThanEqual(percentage);
	}

	public List<Student> fetchByPercentageBetween(double percentage1, double percentage2) {
		return repository.findByPercentageBetween(percentage1, percentage2);
	}

	public List<Student> fetchByPercentageLesser(double percentage) {
		return repository.findByPercentageLessThanEqual(percentage);
	}

	public List<Student> fetchByMathsEnglish(int marks) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> fetchByNameOrNumber(String name, long mobile) {
		return repository.findByNameOrMobile(name, mobile);
	}

	public void deleteById(int id) {
		
		repository.deleteById(id);
	}

}
