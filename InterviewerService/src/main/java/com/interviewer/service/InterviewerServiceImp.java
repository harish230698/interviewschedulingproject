package com.interviewer.service;

import java.net.Authenticator.RequestorType;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.interviewer.entity.AvailabilityStatus;
import com.interviewer.entity.InterviewerEntity;
import com.interviewer.exception.DuplicateInterviewerException;
import com.interviewer.exception.InterviewerNotFoundException;
import com.interviewer.model.InterviewerRequest;
import com.interviewer.model.InterviewerResponse;
import com.interviewer.repository.InterviewerRepo;
import com.interviewer.utils.ResponseMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InterviewerServiceImp implements InterviewerService{
	
	private InterviewerRepo interrepo;
	
	public InterviewerServiceImp(InterviewerRepo repo) {
		this.interrepo=repo;
	}

	@Override
	public InterviewerResponse createInterviewer(InterviewerRequest request) {
		// TODO Auto-generated method stub
		
		if(interrepo.existsByIgnoreCaseEmail(request.email())) {
			throw new DuplicateInterviewerException("Email Already exists");
		}
		
		InterviewerEntity createInterviewer = new InterviewerEntity();
		
		createInterviewer.setId(UUID.randomUUID());
		createInterviewer.setName(request.name());
		createInterviewer.setEmail(request.email());
		createInterviewer.setSkill(request.skill());
		createInterviewer.setDesignation(request.designation());
		createInterviewer.setStatus(AvailabilityStatus.AVAILABLE);
		
		interrepo.save(createInterviewer);
		
		return ResponseMapper.entityToResponse(createInterviewer);
	}

	@Override
	public InterviewerResponse getInterviewer(UUID id) {
		// TODO Auto-generated method stub
		
		InterviewerEntity getInterviewer = interrepo.findById(id)
				.orElseThrow(()-> new InterviewerNotFoundException("Interviewer Not found for the ID : " + id));
		return ResponseMapper.entityToResponse(getInterviewer);
	}

	@Override
	public List<InterviewerResponse> getAvailableInterviewers() {
		// TODO Auto-generated method stub
		return interrepo.findByStatus(AvailabilityStatus.AVAILABLE)
				.stream()
				.map(ResponseMapper::entityToResponse)
				.toList();
	}

	@Override
	public void updateAvailability(UUID id, AvailabilityStatus status) {
		// TODO Auto-generated method stub
		InterviewerEntity getInterviewer = interrepo.findById(id)
				.orElseThrow(()-> new InterviewerNotFoundException("Interviewer Not found for the ID : " + id));
		
		getInterviewer.setStatus(status);
		
		interrepo.save(getInterviewer);
		
	}

}
