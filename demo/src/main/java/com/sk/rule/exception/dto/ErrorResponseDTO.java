package com.sk.rule.exception.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ErrorResponseDTO {
	private String errorMessage;
	private Integer errorCode;
	private LocalDateTime timeStamp;

}
