package com.boyuan.repository;

import com.boyuan.domain.Remind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface RemindRepository extends JpaRepository<Remind,Long> {

    @Override
    @Query("select r from Remind r where r.isDeleted = 0 and r.id = :id")
    Remind findOne(@Param("id") Long id);
}
