package com.hb.test.student.service;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, K extends Serializable> {
    T add(T bean);
    T update(T bean);
    T get(K key);
    T delete(K key);
    List<T> find(T param);
    Page<T> find(T param, Integer pageNo, Integer pageSize);
}
