package com.boyuan.repository;

import com.boyuan.domain.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission,Long> {

    @Override
    @Query("select rp from RolePermission rp where rp.isDeleted = 0 and rp.id = :id")
    RolePermission findOne(@Param("id") Long id);

    @Query("select rp from RolePermission rp where rp.isDeleted = 0 and rp.roleId = :roleId")
    List<RolePermission> findByRoleId(@Param("roleId") Long roleId);

    @Query("select rp from RolePermission rp where rp.isDeleted = 0 and rp.roleId in :roleIds")
    List<RolePermission> findByRoleIds(@Param("roleIds") List<Long> roleIds);
}
