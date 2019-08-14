package com.hb.ztree.test;

import com.hb.ztree.TreeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 测试controller型
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TreeDataSource treeDataSource;

    @Autowired
    private TestDao testDao;

    @RequestMapping("/add")
    public Object add(Test test){
        test.setCreateUserId(1);
        test.setCreatedAt(new Date());

        test.setUpdateUserId(1);
        test.setUpdatedAt(new Date());

        testDao.save(test);
        return "{'code': '200', 'message': '新增成功'}";
    }

    @GetMapping("/tree")
    @ResponseBody
    public Object tree(){
        return treeDataSource.getData();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exception(Exception e){
        return "{'code': '500', 'message': '"+e.getMessage()+"'}";
    }
}
