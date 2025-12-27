package com.notify.model;

import java.util.UUID;

public record Recipient(
		UUID id,
		String email,
		RecipientRole role) {

}
