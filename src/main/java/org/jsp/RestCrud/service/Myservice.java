package org.jsp.RestCrud.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.jsp.RestCrud.dao.Mydao;
import org.jsp.RestCrud.dto.Student;
import org.jsp.RestCrud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Myservice {

	@Autowired
	ResponseStructure<Student> structure;
	@Autowired
	ResponseStructure<List<Student>> structure1;
	@Autowired
	Mydao dao;

	public ResponseEntity<ResponseStructure> insert(Student student) {
		student.setPercentage((student.getMaths() + student.getEnglish() + student.getScience()) / 3.0);
		if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35) {
			student.setResult("fail");
		} else {
			if (student.getPercentage() >= 85) {
				student.setResult("Distinction");
			} else if (student.getPercentage() >= 60) {
				student.setResult("First class");
			} else
				student.setResult("Second class");

		}

		structure.setData(dao.save(student));
		structure.setMessage("Data saved success");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> insertAll(List<Student> students) {
		for (Student student : students) {
			student.setPercentage((student.getMaths() + student.getEnglish() + student.getScience()) / 3.0);
			if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35) {
				student.setResult("fail");
			} else {
				if (student.getPercentage() >= 85) {
					student.setResult("Distinction");
				} else if (student.getPercentage() >= 60) {
					student.setResult("First class");
				} else
					student.setResult("Second class");

			}

			structure1.setData(dao.save(students));
			structure1.setMessage("Data saved success");
			structure1.setStatus(HttpStatus.CREATED.value());

		}
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		List<Student> students = dao.fetchAll();
		structure1.setData((students));
		structure1.setMessage("Data found success");
		structure1.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> fetchById(int id) {
		Student student = dao.fetchById(id);
		structure.setData(dao.save(student));
		structure.setMessage("Data found success");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Student>> fetchByName(String name) {
		Student student = dao.fetchByName(name);
		structure.setData(dao.save(student));
		structure.setMessage("Data found success");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> fetchByMobile(Long mobile) {
		Student student = dao.fetchByMobile(mobile);
		structure.setData(dao.save(student));
		structure.setMessage("Data found success");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

	}

	


	

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(String result) {
		List<Student> students = dao.fetchByResult(result);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with Result: " + result);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageGreater(double percentage) {
		List<Student> students = dao.fetchByPercentageGreater(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present with Percentage Greater: " + percentage);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageBetween(double percentage1,
			double percentage2) {
		List<Student> students = dao.fetchByPercentageBetween(percentage1, percentage2);
		if (students.isEmpty())
			throw new NoSuchElementException(
					"No Records Present with Percentage between: " + percentage1 + " and " + percentage2);
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageLesser(double percentage) {
		List<Student> students = dao.fetchByPercentageLesser(percentage);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMathsEnglish(int marks) {
		List<Student> students = dao.fetchByMathsEnglish(marks);
		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByNameorNumber(String data) {
		List<Student> students = null;
		try {
			students = dao.fetchByNameOrNumber(null, Long.parseLong(data));
		} catch (NumberFormatException e) {
			students = dao.fetchByNameOrNumber(data, 0);
		}

		if (students.isEmpty())
			throw new NoSuchElementException("No Records Present");
		structure1.setMessage("Data Found Success");
		structure1.setData(students);
		structure1.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Student>> deleteById(int id) {
		structure.setData(dao.fetchById(id));
		dao.deleteById(id);
		structure.setMessage("Data Deleted Success");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Student>> update(Student student) {
		student.setPercentage((student.getMaths() + student.getScience() + student.getEnglish()) / 3);
		if (student.getScience() < 35 || student.getEnglish() < 35 || student.getMaths() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}

		structure.setMessage("Data Updated Success");
		structure.setData(dao.save(student));
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);

	}


	}

 
