package com.interviewSchSer.repository.search;

import java.time.LocalDateTime;
import java.util.UUID;

import com.interviewSchSer.entity.InterviewStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="interview_search_view")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InterviewSearchViewEntity {
	
  	@Id
  	@Column(name = "interview_id",columnDefinition = "BINARY(16)")
    private UUID interviewId;
  	
  	@Column(name = "candidate_id",columnDefinition = "BINARY(16)")
    private UUID candidateId;
  	
  	@Column(name = "candidate_name")
    private String candidateName;
  	
  	@Column(name = "interviewer_id",columnDefinition = "BINARY(16)")
    private UUID interviewerId;
  	
  	@Column(name = "interviewer_name")
    private String interviewerName;
  	
  	@Column(name = "scheduled_time")
    private LocalDateTime scheduledTime;
  	
  	@Enumerated(EnumType.STRING)
    private InterviewStatus status;

}
