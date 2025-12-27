package com.candidate.utils;

import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.candidate.entity.CandidateEntity;
import com.candidate.model.CandidateResponse;

public class ResponseMapper {
	
	public static CandidateResponse entityToReponse(CandidateEntity entity) {
		
		CandidateResponse response = new CandidateResponse();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setEmail(entity.getEmail());
		response.setPhone(entity.getPhone());
		response.setExperience(entity.getExperience());
		response.setStatus(entity.getStatus());
		
		return response;
	}

}
