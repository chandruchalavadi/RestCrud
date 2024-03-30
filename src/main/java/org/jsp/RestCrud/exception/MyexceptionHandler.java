package org.jsp.RestCrud.exception;

import java.util.NoSuchElementException;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.jsp.RestCrud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyexceptionHandler {
	@Autowired
	ResponseStructure<String> structure;

	@ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ResponseStructure<String>> handler(DataIntegrityViolationException exception)
  {
	structure.setMessage("Data cannot be saved");
  structure.setStatus(HttpStatus.BAD_REQUEST.value());
  structure.setData("Mobile num is already Exist ");
  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> handler(NoSuchElementException exception) {
		structure.setMessage("Data Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
