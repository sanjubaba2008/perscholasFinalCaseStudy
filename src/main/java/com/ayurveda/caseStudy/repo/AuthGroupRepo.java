package com.ayurveda.caseStudy.repo;

import com.ayurveda.caseStudy.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthGroupRepo extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByCustomerId(Long id);
}
