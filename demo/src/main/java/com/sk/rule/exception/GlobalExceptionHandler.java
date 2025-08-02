package com.sk.rule.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sk.rule.exception.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataValidationException.class)
	public ResponseEntity<ErrorResponseDTO> dataValidationException(DataValidationException exception) {
		ErrorResponseDTO response = ErrorResponseDTO.builder().errorMessage(exception.getMessage())
				.errorCode(HttpStatus.BAD_REQUEST.value()).timeStamp(LocalDateTime.now()).build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}
