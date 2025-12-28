package com.interviewSchSer.service;

import java.net.Authenticator.RequestorType;
import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.interviewSchSer.clientservices.CandidateClient;
import com.interviewSchSer.clientservices.InterviewerClient;
import com.interviewSchSer.entity.InterviewEntity;
import com.interviewSchSer.entity.InterviewMode;
import com.interviewSchSer.entity.InterviewStatus;
import com.interviewSchSer.event.InterviewScheduledEvent;
import com.interviewSchSer.exception.CandidateNotEligibleException;
import com.interviewSchSer.exception.InterviewAlreadyScheduledException;
import com.interviewSchSer.exception.InterviewerNotAvailableException;
import com.interviewSchSer.model.CandidateDTO;
import com.interviewSchSer.model.InterviewResponse;
import com.interviewSchSer.model.InterviewerDTO;
import com.interviewSchSer.model.ScheduleInterviewRequest;
import com.interviewSchSer.repository.InterviewRepository;
import com.interviewSchSer.utils.ResponseMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterviewServiceImp implements InterviewService{

	
	private final InterviewRepository interviewRepository;
    private final ApplicationEventPublisher eventpublisher;
	
	@Override
	@Transactional
	public InterviewResponse scheduleInterview(UUID candidateId,
            UUID interviewerId,
            LocalDateTime scheduledTime,
            InterviewMode mode) {
		

		  InterviewEntity interview = new InterviewEntity();
		  interview.setId(UUID.randomUUID());
		  interview.setCandidateId(candidateId);
		  interview.setInterviewerId(interviewerId);
		  interview.setScheduledTime(scheduledTime);
		  interview.setMode(mode);
		  interview.setStatus(InterviewStatus.SCHEDULED);
		  
		  interviewRepository.saveAndFlush(interview);

		  eventpublisher.publishEvent(
	            new InterviewScheduledEvent(
	                interview.getId(),
	                interview.getCandidateId(),
	                interview.getInterviewerId(),
	                interview.getScheduledTime(),
	                interview.getStatus()
	            )
	        );

	        return ResponseMapper.enityToResponse(interview);

	}

}
