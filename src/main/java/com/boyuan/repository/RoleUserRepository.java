package com.boyuan.repository;

import com.boyuan.domain.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface RoleUserRepository extends JpaRepository<RoleUser,Long> {

    @Override
    @Query("select ru from RoleUser ru where ru.isDeleted = 0")
    List<RoleUser> findAll();

    @Query("select ru from RoleUser ru where ru.isDeleted = 0 and ru.userId = :userId")
    List<RoleUser> findByUserId(@Param("userId") Long userId);
}
