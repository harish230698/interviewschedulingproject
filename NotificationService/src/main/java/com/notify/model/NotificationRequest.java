package com.notify.model;

import java.util.List;

public record NotificationRequest(
		String eventType,
		List<Recipient> receipients,
		String message) {

}
