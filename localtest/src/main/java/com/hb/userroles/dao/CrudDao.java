package com.hb.userroles.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface CrudDao<T, K extends Serializable> extends JpaRepository<T, K> {
    /**
     * 分页获取数据
     */
    Page<T> findAll(Specification<T> spec, Pageable pageable);

    /**
     * 获取所有符合条件的数据
     */
    List<T> findAll(Specification<T> spec, Sort sort);

}
