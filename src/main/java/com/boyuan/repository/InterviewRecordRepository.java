package com.boyuan.repository;

import com.boyuan.domain.InterviewRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface InterviewRecordRepository extends JpaRepository<InterviewRecord,Long> {

    @Override
    @Query("select i from InterviewRecord i where i.isDeleted = 0 and i.id = :id")
    InterviewRecord findOne(@Param("id") Long id);

    @Query("select i from InterviewRecord i where i.isDeleted = 0 and i.token = :token")
    InterviewRecord getByToken(@Param("token") String token);

    @Query("select t from InterviewRecord t where t.isDeleted = 0 and t.candidateId = :candidateId")
    List<InterviewRecord> listByCandidateId(@Param("candidateId") Long candidateId);
}
