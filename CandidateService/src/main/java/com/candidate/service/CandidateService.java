package com.candidate.service;

import java.util.List;
import java.util.UUID;

import com.candidate.entity.CandidateStatus;
import com.candidate.model.CandidateRequest;
import com.candidate.model.CandidateResponse;

public interface CandidateService {
	
	CandidateResponse createCandidate(CandidateRequest request);
	
	CandidateResponse getCandidateByid(UUID id);
	
	List<CandidateResponse> getAllCandidates();
	
	void updateStatus(UUID id,CandidateStatus status);

}
