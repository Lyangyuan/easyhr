package com.boyuan.repository;

import com.boyuan.domain.Employee;
import com.boyuan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long>,JpaSpecificationExecutor<Employee> {

    @Override
    @Query("select e from Employee e where e.isDeleted = 0 and e.id = :id")
    Employee findOne(@Param("id") Long id);

    @Override
    @Query("select t from Employee t where t.isDeleted = 0")
    List<Employee> findAll();
}
