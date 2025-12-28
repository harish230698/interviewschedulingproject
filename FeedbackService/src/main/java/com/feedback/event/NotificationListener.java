package com.feedback.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.feedback.client.InterviewSearchViewClient;
import com.feedback.client.NotificationClient;
import com.feedback.model.NotificationDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationClient notificationClient;
    private final InterviewSearchViewClient interviewClient;
    private final Logger log = Logger.getLogger(NotificationListener.class.getName());
    
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(NotificationFeedbackEvent event) {
    	
    	log.info("Notification listener executed on thread: {" +
                Thread.currentThread().getName() + "}");
    	
    	Map<String,Object> interviewDetail = 
    			interviewClient.getByInterviewId(event.interviewId());

//        CandidateDTO candidate =
//                candidateClient.getCandidate(event.candidateId())

    	int count = (int )interviewDetail.get("numberOfElements");
        
    	if(count<1)
    		return;
    	
    	List<Map<String,String>> contentList = (List<Map<String, String>>) interviewDetail.get("content");
    	
        List<Map<String, String>> recipients = new ArrayList<>();
        
        Map<String,String> candidateRecipient = new HashMap<>();
        
        candidateRecipient.put("id", contentList.get(0).get("candidateId"));
        candidateRecipient.put("email", contentList.get(0).get("candidateEmail"));
        candidateRecipient.put("role", "CANDIDATE");
//        
//        recipients.add(candidateRecipient);
        

        NotificationDTO request = new NotificationDTO(
        							"INTERVIEW_SCHEDULED",
        							recipients,
        							"Result for your Interview - " + event.decision());

        notificationClient.notifyFeedback(request);
    }

}
