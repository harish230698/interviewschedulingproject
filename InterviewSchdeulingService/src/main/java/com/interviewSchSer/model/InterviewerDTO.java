package com.interviewSchSer.model;

import java.util.UUID;

public record InterviewerDTO(
		UUID id,
		String name,
		String email,
		String designation,
		String skill,
		String status) {}
