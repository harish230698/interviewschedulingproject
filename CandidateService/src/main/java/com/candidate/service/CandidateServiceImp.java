
package com.candidate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.candidate.entity.CandidateEntity;
import com.candidate.entity.CandidateStatus;
import com.candidate.exception.CandidateNotFoundException;
import com.candidate.exception.DuplicateCandidateException;
import com.candidate.model.CandidateRequest;
import com.candidate.model.CandidateResponse;
import com.candidate.repository.CandidateRepository;
import com.candidate.utils.ResponseMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CandidateServiceImp implements CandidateService{
	
	private CandidateRepository candidateRepo;
	
	public CandidateServiceImp(CandidateRepository repo) {
		this.candidateRepo=repo;
	}

	@Override
	public CandidateResponse createCandidate(CandidateRequest request) {
		// TODO Auto-generated method stub
		
		 if (candidateRepo.existsByEmail(request.getEmail())) {
	            throw new DuplicateCandidateException(
	                "Candidate already exists with email: " + request.getEmail()
	            );
	        }
		
		CandidateEntity entity = new CandidateEntity();
		
		entity.setId(UUID.randomUUID());
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPhone(request.getPhone());
        entity.setExperience(request.getExperience());
        entity.setStatus(CandidateStatus.APPLIED);
        
        candidateRepo.save(entity);
        
		return ResponseMapper.entityToReponse(entity);
	}

	@Override
	public CandidateResponse getCandidateByid(UUID id) {
		// TODO Auto-generated method stub
		
		CandidateEntity getCandidate = candidateRepo.findById(id)
										.orElseThrow(() -> new CandidateNotFoundException("Candidate not found | ID : " + id));
			
		return ResponseMapper.entityToReponse(getCandidate);
	}

	@Override
	public List<CandidateResponse> getAllCandidates() {
		// TODO Auto-generated method stub
		return candidateRepo.findAll().stream()
				.map(ResponseMapper::entityToReponse)
				.toList();
	}

	@Override
	public void updateStatus(UUID id, CandidateStatus status) {
		// TODO Auto-generated method stub
		CandidateEntity updateentity = candidateRepo.findById(id)
											.orElseThrow(()-> new CandidateNotFoundException("Status Update Restricted as Candidate not found | ID : " + id));
		
		updateentity.setStatus(status);
		candidateRepo.save(updateentity);
	}

}
