package com.learning.jdk8.personalfinancial.repository;

import com.learning.jdk8.personalfinancial.domain.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Long> {
}
