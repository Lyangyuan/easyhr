package com.boyuan.repository;

import com.boyuan.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface CandidateRepository extends JpaRepository<Candidate,Long>,JpaSpecificationExecutor<Candidate> {

    @Override
    @Query("select c from Candidate c where c.isDeleted = 0 and c.id = :id")
    Candidate findOne(@Param("id") Long id);
}
