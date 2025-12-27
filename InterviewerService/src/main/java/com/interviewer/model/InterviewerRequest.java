package com.interviewer.model;

import com.interviewer.entity.AvailabilityStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InterviewerRequest(
		
		@NotBlank(message ="Name should not be null")
		String name,
		
		@Email(message = "Invalid Email")
		@NotBlank
		String email,
		
		String skill,
		
		@NotBlank
		String designation,
		
		AvailabilityStatus status
		) {

}
