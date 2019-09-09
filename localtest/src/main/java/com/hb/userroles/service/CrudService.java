package com.hb.userroles.service;

import com.hb.userroles.dao.CrudDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基本的增删改查
 */
public interface CrudService<T, K extends Serializable> {

    /**
     * 新增
     * @param obj
     * @return
     */
    T add(T obj);

    /**
     * 删除
     * @param id
     */
    void delete(K id);

    /**
     * 修改
     * @param obj
     */
    void update(T obj);

    /**
     * 新增或修改
     * @param obj
     */
    void save(T obj);

    /**
     * 修改数据，只属性名称指定的属性
     * @param obj
     * @param properties 属性名称
     */
    void update(T obj, String[] properties);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T get(K id);

    /**
     * 查询符合条件前10条数据
     * @param params 查询参数
     * @param sort 排序参数
     * @return
     */
    List<T> findTop10(Map<String, String[]> params, Sort sort);

    /**
     * 查询符合条件的所有数据
     * @param params 查询参数
     * @return
     */
    List<T> findAll(Map<String, String[]> params, Sort sort);

    /**
     * 分页查询
     * @param params 查询参数
     * @param pageable 分页和排序信息
     * @return
     */
    Page<T> findPage(Map<String, String[]> params, Pageable pageable);

    /**
     * 按属性查询
     * @param params
     * @return
     */
    T findOne(T params);

    CrudDao<T, K> getDao();
}
