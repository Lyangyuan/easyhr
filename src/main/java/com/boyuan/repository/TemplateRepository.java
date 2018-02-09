package com.boyuan.repository;

import com.boyuan.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
public interface TemplateRepository extends JpaRepository<Template,Long>,JpaSpecificationExecutor<Template> {

    @Override
    @Query("select t from Template t where t.isDeleted = 0 and t.id = :id")
    Template findOne(@Param("id") Long id);

    @Query("select t from Template t where t.isDeleted = 0 and t.name like %:name%")
    List<Template> listByName(@Param("name") String name);
}
