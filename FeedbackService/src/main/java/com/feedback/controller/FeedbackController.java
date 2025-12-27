package com.feedback.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.model.FeedbackRequest;
import com.feedback.model.FeedbackResponse;
import com.feedback.service.FeedbackService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FeedbackController {
	
	private final FeedbackService feedbackService;

    @PostMapping("/submitFeedback")
    public ResponseEntity<FeedbackResponse> submit(
            @Valid @RequestBody FeedbackRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(feedbackService.submitFeedback(request));
    }

    @GetMapping("/getFeedbackByInterview/{interviewId}")
    public ResponseEntity<FeedbackResponse> getByInterview(
            @PathVariable UUID interviewId) {
        return ResponseEntity.ok(feedbackService.getByInterviewId(interviewId));
    }
    
    @GetMapping("/getFeedbackByInterviewer/{interviewerId}")
    public ResponseEntity<List<FeedbackResponse>> getByInterviewer(
            @PathVariable UUID interviewerId) {
        return ResponseEntity.ok(feedbackService.getByInterviewerId(interviewerId));
    }

}
