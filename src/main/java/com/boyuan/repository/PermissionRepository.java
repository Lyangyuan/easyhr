package com.boyuan.repository;

import com.boyuan.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    @Override
    @Query("select p from Permission p where p.isDeleted = 0 and p.id = :id")
    Permission findOne(@Param("id") Long id);

    @Override
    @Query("select p from Permission p where p.isDeleted = 0")
    List<Permission> findAll();
}
