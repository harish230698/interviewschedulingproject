package com.candidate.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.entity.CandidateStatus;
import com.candidate.model.CandidateRequest;
import com.candidate.model.CandidateResponse;
import com.candidate.service.CandidateService;

@RestController
@RequestMapping("/api/v1")
public class CandidateController {
	
	private final CandidateService candidateSer;
	
	public CandidateController(CandidateService service) {
		this.candidateSer=service;
	}
	
	 @GetMapping("/ping")
	    public String ping() {
	        return "Candidate Service is UP";
	    }
	
 	@PostMapping("/registerCandidate")
    public ResponseEntity<CandidateResponse> create(@RequestBody CandidateRequest request) {
        return ResponseEntity.ok(candidateSer.createCandidate(request));
    }

    @GetMapping("/getCandidateById/{id}")
    public ResponseEntity<CandidateResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(candidateSer.getCandidateByid(id));
    }

    @GetMapping("/getCandidates")
    public ResponseEntity<List<CandidateResponse>> getAll() {
        return ResponseEntity.ok(candidateSer.getAllCandidates());
    }

    @PatchMapping("/updateStatus/{id}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable UUID id,
            @RequestParam CandidateStatus status) {
    	candidateSer.updateStatus(id, status);
        return ResponseEntity.noContent().build();
    }

}
