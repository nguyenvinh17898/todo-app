package com.vinhnguyen.crudapi.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// error handle for @Valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		Map<String, List<String>> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			List<String> errorMessage = new ArrayList<String>();
			if (errors.get(fieldName) != null) {
				errorMessage = errors.get(fieldName);
				errorMessage.add(error.getDefaultMessage());
			} else {
				errorMessage.add(error.getDefaultMessage());
			}
			errors.put(fieldName, errorMessage);
		});
		// Get all errors
//		System.out.println(errors2);
//		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
//				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}

}