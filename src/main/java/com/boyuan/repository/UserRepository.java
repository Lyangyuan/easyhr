package com.boyuan.repository;

import com.boyuan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2017/12/9
 */
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.isDeleted = 0 and u.account = :account")
    User getUserByAccount(@Param("account") String account);

    @Override
    @Query("select u from User u where u.isDeleted = 0 and u.id = :id")
    User findOne(@Param("id") Long id);

    @Override
    @Query("select t from User t where t.isDeleted = 0")
    List<User> findAll();
}
