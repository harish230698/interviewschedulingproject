package com.interviewer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interviewer.entity.AvailabilityStatus;
import com.interviewer.entity.InterviewerEntity;
import java.util.List;

@Repository
public interface InterviewerRepo extends JpaRepository<InterviewerEntity, UUID>{
	
	
	boolean existsByIgnoreCaseEmail(String email);
	
	List<InterviewerEntity> findByStatus(AvailabilityStatus status);

}
