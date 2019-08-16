package com.hb.ztree.test;

import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class TestListeren {
    @PreUpdate
    public void preUpdate(Test entity) {
        entity.setUpdatedAt(new Date());
        entity.setUpdateUserId(-100);
    }

    @PrePersist
    public void prePersist(Test entity) {
        entity.setUpdatedAt(new Date());
        entity.setUpdateUserId(-100);

        entity.setCreatedAt(new Date());
        entity.setCreateUserId(-100);
    }

}
