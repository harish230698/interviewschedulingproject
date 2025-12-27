package com.interviewSchSer.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.interviewSchSer.clientservices.CandidateClient;
import com.interviewSchSer.clientservices.InterviewerClient;
import com.interviewSchSer.clientservices.NotificationClient;
import com.interviewSchSer.model.CandidateDTO;
import com.interviewSchSer.model.InterviewerDTO;
import com.interviewSchSer.model.NotificationDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InterviewNotificationListener {
	
	private final CandidateClient candidateClient;
    private final InterviewerClient interviewerClient;
    private final NotificationClient notificationClient;
    private final Logger log = Logger.getLogger(InterviewNotificationListener.class.getName());;
    
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(InterviewScheduledEvent event) {
    	
    	log.info("Notification listener executed on thread: {}" +
                Thread.currentThread().getName());

        CandidateDTO candidate =
                candidateClient.getCandidate(event.candidateId());

        InterviewerDTO interviewer =
                interviewerClient.getInterviewer(event.interviewerId());
        
        List<Map<String, String>> recipients = new ArrayList<>();
        
        Map<String,String> candidateRecipient = new HashMap<>();
        
        candidateRecipient.put("id", candidate.id().toString());
        candidateRecipient.put("email", candidate.email());
        candidateRecipient.put("role", "CANDIDATE");
        
        recipients.add(candidateRecipient);
        
        Map<String,String> interviewerRecipient = new HashMap<>();
        
        interviewerRecipient.put("id", interviewer.id().toString());
        interviewerRecipient.put("email", interviewer.email());
        interviewerRecipient.put("role", "INTERVIEWER");
        
        recipients.add(interviewerRecipient);
        

        NotificationDTO request = new NotificationDTO(
        							"INTERVIEW_SCHEDULED",
        							recipients,
        							"Interview scheduled on " + event.scheduledTime());

        notificationClient.notifyInterviewScheduled(request);
    }

}
