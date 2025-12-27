package com.interviewSchSer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interviewSchSer.entity.InterviewEntity;
import com.interviewSchSer.entity.InterviewStatus;

public interface InterviewRepository extends JpaRepository<InterviewEntity, UUID> {
	
	 boolean existsByCandidateIdAndStatus(UUID candidateId,InterviewStatus status);

}
