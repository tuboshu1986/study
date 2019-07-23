package com.hb.test.student.dao.listener;

import com.hb.test.student.handler.BaseModelHandler;
import com.hb.test.student.model.BaseModel;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class BaseListener{

    @PreUpdate
    public void preUpdate(Object entity) {
        System.out.println(">>>>PreUpdate");
        BaseModel bean = (BaseModel)entity;
        BaseModelHandler.setUpdateDefaultColumn(bean);
    }

    @PrePersist
    public void prePersist(Object entity) {
        System.out.println(">>>>PrePersist");
        BaseModel bean = (BaseModel)entity;
        BaseModelHandler.setCreateDefaultColumn(bean);
    }

}
