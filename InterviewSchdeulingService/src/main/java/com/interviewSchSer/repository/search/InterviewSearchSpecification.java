package com.interviewSchSer.repository.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.interviewSchSer.entity.InterviewEntity;
import com.interviewSchSer.model.InterviewSearchCriteria;

import jakarta.persistence.criteria.Predicate;

public class InterviewSearchSpecification {
	
	private InterviewSearchSpecification() {}
	
	
	public static Specification<InterviewSearchViewEntity> build(InterviewSearchCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.interviewerName() != null) {
                predicates.add(
                    cb.like(cb.lower(root.get("interviewerName")),
                            "%" + criteria.interviewerName().toLowerCase() + "%")
                );
            }

            if (criteria.candidateName() != null) {
                predicates.add(
                    cb.like(cb.lower(root.get("candidateName")),
                            "%" + criteria.candidateName().toLowerCase() + "%")
                );
            }
            
            if(criteria.interviewId() !=null) {
            	predicates.add(
            			cb.equal(root.get("interviewId"), criteria.interviewId())
            	);
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
