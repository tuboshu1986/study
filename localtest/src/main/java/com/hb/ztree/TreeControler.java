package com.hb.ztree;


import com.hb.ztree.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 通用controller
 */
public abstract class TreeControler<T extends TreeModel> {

    @Autowired
    private TreeDataSource treeDataSource;

    @RequestMapping("/get")
    @ResponseBody
    public Object get(Integer id){
        TreeModel data = treeDataSource.findOne(id);
        if(data.getParentId() != null){
            data.setParent(treeDataSource.findOne(data.getParentId()));
        }
        return treeDataSource.findOne(id);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(T test){
        treeDataSource.save(test);
        if(test.getId() == null){
            return "{\"code\": \"200\", \"message\": \"新增成功\"}";
        }else{
            return "{\"code\": \"200\", \"message\": \"更新成功\"}";
        }
    }

    @RequestMapping("/tree")
    @ResponseBody
    public Object tree(){
        return treeDataSource.getData();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exception(Exception e){
        e.printStackTrace();
        return "{\"code\": \"500\", \"message\": \""+e.getMessage()+"\"}";
    }
}
