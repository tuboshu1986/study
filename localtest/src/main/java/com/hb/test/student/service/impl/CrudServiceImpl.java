package com.hb.test.student.service.impl;

import com.hb.test.student.model.BaseModel;
import com.hb.test.student.service.BaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceImpl<T extends BaseModel, K extends Serializable> implements BaseService<T, K> {
    @Override
    @Transactional
    public T add(T bean) {
        return (T)getRepository().save(bean);
    }

    @Override
    @Transactional
    public T update(T bean) {
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

    public abstract JpaRepository<T, K> getRepository();
}
