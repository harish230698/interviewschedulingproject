package com.interviewSchSer.event;

import java.time.LocalDateTime;
import java.util.UUID;

import com.interviewSchSer.entity.InterviewStatus;

public record InterviewScheduledEvent(
		UUID interviewId,
        UUID candidateId,
        UUID interviewerId,
        LocalDateTime scheduledTime,
        InterviewStatus status
        ) {

}
