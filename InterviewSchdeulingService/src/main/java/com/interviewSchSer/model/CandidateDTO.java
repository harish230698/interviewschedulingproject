package com.interviewSchSer.model;

import java.util.UUID;

public record CandidateDTO(
		UUID id,
		String name,
		String email,
		String phone,
		Integer experience,
		String status) {}
