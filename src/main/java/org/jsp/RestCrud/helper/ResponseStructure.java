package org.jsp.RestCrud.helper;

import org.jsp.RestCrud.dto.Student;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data

public class ResponseStructure<T> {
String message;
int status;
T data;
}
	