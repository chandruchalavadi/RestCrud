package org.jsp.RestCrud.controller;

import java.util.List;

import org.jsp.RestCrud.dto.Student;
import org.jsp.RestCrud.helper.ResponseStructure;
import org.jsp.RestCrud.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mycontroller {
	@Autowired
	Myservice service;

	@PostMapping("/students")
	@ResponseBody
	public ResponseEntity<ResponseStructure> insert(@RequestBody Student student) {
		return service.insert(student);
	}

	@GetMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}

	@GetMapping("/students/many")
	@ResponseBody
	public ResponseEntity<ResponseStructure<List<Student>>> Students(@RequestBody List<Student> students) {
		return service.insertAll(students);
	}

	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		return service.fetchAll();
	}

	@GetMapping("/students/id")
	public ResponseEntity<ResponseStructure<Student>> fetchById(@RequestParam int id) {
		return service.fetchById(id);
	}

	@GetMapping("/students/name")
	public ResponseEntity<ResponseStructure<Student>> fetchByName(@RequestParam String name) {
		return service.fetchByName(name);
	}

	@GetMapping("/students/mobile")
	public ResponseEntity<ResponseStructure<Student>> fetchByMobile(@RequestParam Long mobile) {
		return service.fetchByMobile(mobile);
	}

	
	@GetMapping("/students/result/{result}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(@PathVariable String result) {
		return service.fetchByResult(result);
	}


	@GetMapping("/students/percentage/greater/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageGreater(@PathVariable double percentage) {
		return service.fetchByPercentageGreater(percentage);
	}

	
	@GetMapping("/students/percentage/{percentage1}/{percentage2}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageBetween(@PathVariable double percentage1,
			@PathVariable double percentage2) {
		return service.fetchByPercentageBetween(percentage1, percentage2);
	}


	@GetMapping("/students/percentage/lesser/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByPercentageLesser(@PathVariable double percentage) {
		return service.fetchByPercentageLesser(percentage);
	}

	
	@GetMapping("/students/maths/english/{marks}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMathsEnglish(@PathVariable int marks) {
		return service.fetchByMathsEnglish(marks);
	}


	@GetMapping("/students/nameornumber/{data}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByNameorNumber(@PathVariable String data) {
		return service.fetchByNameorNumber(data);
	}

	
	@DeleteMapping("/students/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}


	@PutMapping("/students")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestBody Student student) {
		return service.update(student);
	}
//	
//	//Update Particular 
//	@PatchMapping("/students/id/{id}")
//	public ResponseEntity<ResponseStructure<Student>> update(@PathVariable int id,@RequestBody Student student) {
//		return service.update(id,student);
//	}
}
