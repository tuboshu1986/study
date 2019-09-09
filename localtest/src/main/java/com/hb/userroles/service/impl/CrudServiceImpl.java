package com.hb.userroles.service.impl;

import com.hb.userroles.service.CrudService;
import com.moko.erp.productmanage.common.BeanUtil;
import com.moko.erp.productmanage.domain.BaseModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class CrudServiceImpl<T, K extends Serializable> implements CrudService<T, K> {

    @Override
    @Transactional
    public T add(T obj) {
        return getDao().save(obj);
    }

    @Override
    @Transactional
    public void delete(K id) {
        getDao().delete(id);
        getDao().flush();
    }

    @Override
    @Transactional
    public void update(T obj) {
        if(obj instanceof BaseModel){
            BaseModel baseObj = (BaseModel)obj;
            T oldData = getDao().findOne((K)baseObj.getId());
            BeanUtil.copyFieldIfNotNull(obj, oldData);
            getDao().save(oldData);
            getDao().flush();
            return;
        }
        getDao().save(obj);
        getDao().flush();
    }

    /**
     * 判断id是否为空，如果为空则调用add方法否则调用update方法
     * @param obj
     */
    @Override
    @Transactional
    public void save(T obj){
        if(obj instanceof BaseModel){
            BaseModel baseObj = (BaseModel)obj;
            if(baseObj.getId() == null){
                this.add(obj);
            }else{
                this.update(obj);
            }
        }
    }

    @Override
    @Transactional
    public void update(T obj, String[] properties) {
        if(obj instanceof BaseModel){
            BaseModel baseObj = (BaseModel)obj;
            T oldObj = getDao().findOne((K)baseObj.getId());
            BeanUtil.copyFields(obj, oldObj, properties);
            getDao().save(oldObj);
            getDao().flush();
            return;
        }
        getDao().save(obj);
        getDao().flush();
    }

    @Override
    public T get(K id) {
        return (T)getDao().findOne(id);
    }

    @Override
    public List<T> findTop10(Map<String, String[]> params, Sort sort) {
        return getDao().findAll(createParams(params), new PageRequest(0, 10, sort)).getContent();
    }

    @Override
    public List<T> findAll(Map<String, String[]> params, Sort sort) {
        return getDao().findAll(createParams(params), sort);
    }

    @Override
    public Page<T> findPage(Map<String, String[]> params, Pageable pageable) {
        return getDao().findAll(createParams(params), pageable);
    }

    @Override
    public T findOne(T params) {
        return getDao().findOne(Example.of(params));
    }

    public abstract Class<T> modelClass();

    /**
     * 为查询条件添加权限控制信息，控制数据的可见性
     * @param pred
     * @param root
     * @param cb
     * @return
     */
    public Predicate permissionCtl(Predicate pred, Root<T> root, CriteriaBuilder cb){
        return pred;
    }

    private Specification<T> createParams(Map<String, String[]> params){
//        Collection<SearchFilter> filters = SearchFilter.parse(params).values();
//        final Specification<T> fsp = SearchFilter.spec(filters, modelClass());
//        Specification<T> sp = new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Predicate pred = fsp.toPredicate(root, query, cb);
//                pred = permissionCtl(pred, root, cb);
//                return pred;
//            }
//        };
        return null;
    }

}
