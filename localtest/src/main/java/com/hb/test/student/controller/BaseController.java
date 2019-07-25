package com.hb.test.student.controller;

import com.hb.test.student.model.BaseModel;
import com.hb.test.student.service.BaseService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseController<T extends BaseModel, K extends Serializable> {
    @GetMapping("/{key}")
    public String get(@PathVariable("key") K key, ModelMap model){
        model.addAttribute("beandData", getService().get(key));
        model.addAttribute("beandOptType", OptType.VIEW);
        return pre() + "/model";
    }

    @PostMapping
    public String post(T param, ModelMap model, OptType optType){
        T rstBean = getService().update(param);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.UPDATE);
        return pre() + "/model";
    }

    @PutMapping
    public String put(T param, ModelMap model){
        T rstBean = getService().add(param);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.ADD);
        return pre() + "/model";
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable("key") K key, ModelMap model){
        T rstBean = getService().delete(key);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.DELETE);
        return pre() + "/list";
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
