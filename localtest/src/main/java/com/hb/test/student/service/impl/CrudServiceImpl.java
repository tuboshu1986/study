package com.hb.test.student.service.impl;

import com.hb.test.student.model.BaseModel;
import com.hb.test.student.service.BaseService;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceImpl<T extends BaseModel, K extends Integer> implements BaseService<T, K> {
    @Override
    @Transactional
    public T add(T bean) {
        return (T)getRepository().save(bean);
    }

    @Override
    @Transactional
    public T update(T bean) {
        T dbBean =  this.getRepository().findOne((K)bean.getId());
        bean.setStatus(dbBean.getStatus());
        bean.setVersion(dbBean.getVersion());
        return (T)getRepository().save(bean);
    }

    @Override
    public T get(K key) {
        return getRepository().findOne(key);
    }

    @Override
    @Transactional
    public T delete(K key) {
        T obj = getRepository().getOne(key);
        getRepository().delete(key);
        return obj;
    }

    @Override
    public List<T> find(T param) {
        return getRepository().findAll(Example.of(param));
    }

    @Override
    public Page<T> find(T param, Integer pageNo, Integer pageSize){
        Pageable page = new PageRequest(pageNo, pageSize, Sort.Direction.DESC, "updateTime");
        return getRepository().findAll(Example.of(param), page);
    }

    public abstract JpaRepository<T, K> getRepository();
}
