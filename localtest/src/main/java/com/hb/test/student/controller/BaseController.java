package com.hb.test.student.controller;

import com.hb.test.student.model.BaseModel;
import com.hb.test.student.service.BaseService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseController<T extends BaseModel, K extends Serializable> {
    @GetMapping("/{key}")
    public String get(@PathVariable("key") K key, Model model){
        model.addAttribute("beandData", getService().get(key));
        model.addAttribute("beandOptType", OptType.VIEW);
        return pre() + "/model.html";
    }

    @PostMapping
    public String post(T param, Model model, OptType optType){
        T rstBean = getService().update(param);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.UPDATE);
        return pre() + "/model.html";
    }

    @PutMapping
    public String put(T param, Model model){
        T rstBean = getService().add(param);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.ADD);
        return pre() + "/model.html";
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable("key") K key, Model model){
        T rstBean = getService().delete(key);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.DELETE);
        return pre() + "/list.html";
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public String page(T param, Integer pageNo, Integer pageSize){
        return pre() + "/list.html";
    }

    public abstract BaseService<T, K> getService();

    public abstract String pre();

    public static enum OptType {
        VIEW,ADD,UPDATE,DELETE
    }

}
