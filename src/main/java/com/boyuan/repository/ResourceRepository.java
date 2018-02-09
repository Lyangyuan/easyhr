package com.boyuan.repository;

import com.boyuan.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
public interface ResourceRepository extends JpaSpecificationExecutor<Resource>,JpaRepository<Resource,Long> {

    @Override
    @Query("select t from Resource t where t.isDeleted = 0 and t.id = :id")
    Resource findOne(@Param("id") Long id);

    @Query("select t from Resource t where t.isDeleted = 0 and t.parentId = :parentId")
    List<Resource> listByParentId(@Param("parentId") Long parentId);
}
