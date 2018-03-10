package com.boyuan.repository;

import com.boyuan.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Override
    @Query("select role from Role role where role.isDeleted = 0 and role.id = :id")
    Role findOne(@Param("id") Long id);

    @Override
    @Query("select role from Role role where role.isDeleted = 0")
    List<Role> findAll();

    @Query("select r from Role r where r.isDeleted = 0 and r.roleName = :roleName")
    Role findByName(@Param("roleName") String roleName);
}
