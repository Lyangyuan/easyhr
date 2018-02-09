package com.boyuan.repository;

import com.boyuan.domain.Memorandum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface MemorandumRepository extends JpaRepository<Memorandum,Long> {

    @Override
    @Query("select m from Memorandum m where m.isDeleted = 0 and m.id = :id")
    Memorandum findOne(@Param("id") Long id);
}
