package org.jsp.RestCrud.repository;

import java.util.List;

import org.jsp.RestCrud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Myrepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);

	Student findByMobile(Long mobile);

	List<Student> findByNameOrMobile(String name, long mobile);

	List<Student> findByResult(String result);

	List<Student> findByPercentageGreaterThanEqual(double percentage);

	List<Student> findByPercentageBetween(double percentage1, double percentage2);

	List<Student> findByPercentageLessThanEqual(double percentage);

}
