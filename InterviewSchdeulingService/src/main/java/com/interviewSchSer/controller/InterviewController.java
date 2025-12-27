package com.interviewSchSer.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewSchSer.model.InterviewResponse;
import com.interviewSchSer.model.InterviewSearchCriteria;
import com.interviewSchSer.model.ScheduleInterviewRequest;
import com.interviewSchSer.repository.search.InterviewSearchSpecification;
import com.interviewSchSer.repository.search.InterviewSearchViewEntity;
import com.interviewSchSer.repository.search.InterviewSearchViewRepository;
import com.interviewSchSer.service.InterviewService;
import com.interviewSchSer.utils.ResponseMapper;
import com.interviewSchSer.model.InterviewSearchViewResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InterviewController {
	
	 private final InterviewService interviewService;
	 private final InterviewSearchViewRepository interviewSearchViewRepository;

    @PostMapping("/schedule")
    public InterviewResponse schedule(@RequestBody ScheduleInterviewRequest request) {

        return interviewService.scheduleInterview(
                request.candidateId(),
                request.interviewerId(),
                request.scheduledTime(),
                request.mode()
        );
    }
    
    @GetMapping("/search")
    public Page<InterviewSearchViewResponse> search(@ModelAttribute InterviewSearchCriteria criteria,
            Pageable pageable) {
    	
    	Page<InterviewSearchViewEntity> entity = interviewSearchViewRepository.findAll(
                InterviewSearchSpecification.build(criteria),
                pageable
            );

        return entity.map(ResponseMapper::enityToSearchViewResponse);
    }
}
