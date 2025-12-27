package com.feedback.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="feedback")
@Getter
@Setter
public class FeedbackEntity {
	
	@Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "interview_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID interviewId;

    @Column(name = "interviewer_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID interviewerId;

    @Min(1)
    @Max(5)
    private int rating;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String comments;

    @Enumerated(EnumType.STRING)
    private Decision decision;

}
