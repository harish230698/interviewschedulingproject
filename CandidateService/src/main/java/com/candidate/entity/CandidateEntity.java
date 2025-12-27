package com.candidate.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class CandidateEntity {
	
	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	private String phone;
	
	private int experience;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CandidateStatus status;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public CandidateStatus getStatus() {
		return status;
	}

	public void setStatus(CandidateStatus status) {
		this.status = status;
	}
	

}
