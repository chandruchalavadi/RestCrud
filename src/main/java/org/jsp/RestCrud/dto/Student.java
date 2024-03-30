package org.jsp.RestCrud.dto;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
//	@Column(unique = true)
	String name;
	@Column(unique = true)
	long mobile;
    int maths;
    int science;
    int english;
    LocalDate dob;
    double percentage;
    String result;

}
