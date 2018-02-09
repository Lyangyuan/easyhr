package com.boyuan.repository;

import com.boyuan.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
public interface PostRepository extends JpaRepository<Post,Long>,JpaSpecificationExecutor<Post> {

    @Override
    @Query("select  p from Post p where p.isDeleted = 0 and p.id = :id")
    Post findOne(@Param("id") Long id);
}
