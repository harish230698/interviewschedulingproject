package com.interviewSchSer.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "interview")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterviewEntity {
	
	@Id
	@Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "candidate_id", nullable = false,columnDefinition = "BINARY(16)")
    private UUID candidateId;

    @Column(name = "interviewer_id", nullable = false,columnDefinition = "BINARY(16)")
    private UUID interviewerId;

    private LocalDateTime scheduledTime;

    @Enumerated(EnumType.STRING)
    private InterviewMode mode;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;
}
