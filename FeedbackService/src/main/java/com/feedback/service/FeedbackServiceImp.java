package com.feedback.service;

import java.nio.MappedByteBuffer;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.feedback.entity.FeedbackEntity;
import com.feedback.model.FeedbackRequest;
import com.feedback.model.FeedbackResponse;
import com.feedback.repository.FeedbackRepository;
import com.feedback.utils.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImp implements FeedbackService {
	
	private final FeedbackRepository feedbackrepo;

	@Override
	public FeedbackResponse submitFeedback(FeedbackRequest request) {
		// TODO Auto-generated method stub
		
		FeedbackEntity submitfeedback = Mapper.requestToEntity(request);
		submitfeedback.setId(UUID.randomUUID());
		
		feedbackrepo.save(submitfeedback);
		
		return Mapper.entityToResponse(submitfeedback);
	}

	@Override
	public FeedbackResponse getByInterviewId(UUID interviewId) {
		// TODO Auto-generated method stub
		
		FeedbackEntity getinterview = feedbackrepo.getReferenceById(interviewId);
		
		 return Mapper.entityToResponse(getinterview);
	}

	@Override
	public List<FeedbackResponse> getByInterviewerId(UUID interviewerId) {
		// TODO Auto-generated method stub
		return feedbackrepo.findByInterviewerId(interviewerId)
                .stream()
                .map(Mapper::entityToResponse)
                .toList();
	}

}
