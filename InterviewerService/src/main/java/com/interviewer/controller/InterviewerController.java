package com.interviewer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interviewer.entity.AvailabilityStatus;
import com.interviewer.model.InterviewerRequest;
import com.interviewer.model.InterviewerResponse;
import com.interviewer.service.InterviewerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class InterviewerController {
	
	private final InterviewerService interSer;
	
	public InterviewerController(InterviewerService service) {
		this.interSer = service;
	}
	
	@PostMapping("/registerInterviewer")
    public ResponseEntity<InterviewerResponse> create(
            @Valid @RequestBody InterviewerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(interSer.createInterviewer(request));
    }

    @GetMapping("/getInterviewer/{id}")
    public ResponseEntity<InterviewerResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(interSer.getInterviewer(id));
    }

    @GetMapping("/availableInterviewer")
    public ResponseEntity<List<InterviewerResponse>> available() {
        return ResponseEntity.ok(interSer.getAvailableInterviewers());
    }

    @PatchMapping("/updateStatus/{id}/availability")
    public ResponseEntity<Void> updateAvailability(
            @PathVariable UUID id,
            @RequestParam AvailabilityStatus status) {
    	interSer.updateAvailability(id, status);
        return ResponseEntity.noContent().build();
    }

}
