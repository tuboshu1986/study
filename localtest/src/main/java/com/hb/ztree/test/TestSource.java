package com.hb.ztree.test;

import com.hb.ztree.Item;
import com.hb.ztree.TreeDataSource;
import com.hb.ztree.TreeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestSource implements TreeDataSource {

    @Autowired
    private TestDao testDao;

    @Override
    public Test findOne(Integer id) {
        return testDao.findOne(id);
    }

    @Override
    public Test save(TreeModel obj) {
        return testDao.save((Test)obj);
    }

    @Override
    public List<Item> getData() {
        List<Item> rst = new ArrayList<>();
        testDao.findAll().forEach(t -> {
            rst.add(new Item(t.getId().toString(), t.getParentId() == null ? null : t.getParentId().toString(), t.getName()));
        });
        return rst;
    }
}
