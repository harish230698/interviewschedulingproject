package com.interviewSchSer.repository.search;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InterviewSearchViewRepository extends 
													JpaRepository<InterviewSearchViewEntity, UUID>,
													JpaSpecificationExecutor<InterviewSearchViewEntity> {

}
