package com.candidate.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candidate.entity.CandidateEntity;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
	
	Optional<CandidateEntity> findByEmail(String email);
	
	boolean existsByEmail(String email);

}
