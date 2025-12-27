package com.interviewSchSer.model;

import java.util.List;
import java.util.Map;

public record NotificationDTO(
		String eventType,
		List<Map<String,String>> receipients,
		String message
		) {

}
