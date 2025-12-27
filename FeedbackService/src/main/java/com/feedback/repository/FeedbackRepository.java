package com.feedback.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.entity.FeedbackEntity;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, UUID>{

	 	List<FeedbackEntity> findByInterviewId(UUID interviewId);

	    List<FeedbackEntity> findByInterviewerId(UUID interviewerId);
}
