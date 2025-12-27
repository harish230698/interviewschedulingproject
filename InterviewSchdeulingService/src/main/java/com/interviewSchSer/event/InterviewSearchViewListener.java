package com.interviewSchSer.event;

import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.interviewSchSer.clientservices.CandidateClient;
import com.interviewSchSer.clientservices.InterviewerClient;
import com.interviewSchSer.model.CandidateDTO;
import com.interviewSchSer.model.InterviewerDTO;
import com.interviewSchSer.repository.search.InterviewSearchViewEntity;
import com.interviewSchSer.repository.search.InterviewSearchViewRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InterviewSearchViewListener {
	
	private final CandidateClient candidateClient;
    private final InterviewerClient interviewerClient;
    private final InterviewSearchViewRepository repository;
    private final Logger log = Logger.getLogger(InterviewSearchViewListener.class.getName());

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(InterviewScheduledEvent event) {
    	
    	log.info("SearchView listener executed on thread: {}" +
                Thread.currentThread().getName());

        CandidateDTO candidate = candidateClient.getCandidate(event.candidateId());
        InterviewerDTO interviewer = interviewerClient.getInterviewer(event.interviewerId());

        InterviewSearchViewEntity view = new InterviewSearchViewEntity(
                event.interviewId(),
                event.candidateId(),
                candidate.name(),
                event.interviewerId(),
                interviewer.name(),
                event.scheduledTime(),
                event.status()
        );

        repository.save(view);
    }


}
