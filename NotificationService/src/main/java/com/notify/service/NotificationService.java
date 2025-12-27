package com.notify.service;

import com.notify.model.NotificationRequest;

public interface NotificationService {

	void sendInterviewScheduledNotification(NotificationRequest req);
	
	void sendFeedbackNotification(NotificationRequest req);
}
