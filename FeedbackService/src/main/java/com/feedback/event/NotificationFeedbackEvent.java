package com.feedback.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationFeedbackEvent(
		UUID feedbackId,
		UUID interviewId,
        UUID interviewerId,
        String decision
        ) {
}
