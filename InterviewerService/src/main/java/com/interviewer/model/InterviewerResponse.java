package com.interviewer.model;

import java.util.UUID;

import com.interviewer.entity.AvailabilityStatus;

public record InterviewerResponse(
		UUID id,
		String name,
		String email,
		String designation,
		String skill,
		AvailabilityStatus status		
		) {}
