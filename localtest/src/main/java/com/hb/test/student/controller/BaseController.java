package com.hb.test.student.controller;

import com.hb.test.student.handler.define.PageInfo;
import com.hb.test.student.model.BaseModel;
import com.hb.test.student.service.BaseService;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseController<T extends BaseModel, K extends Serializable> {
    /**操作成功**/
    private static Integer OPERATION_FAILED = 400;
    /**操作失败**/
    private static Integer OPERATION_SUCCESS = 200;

    @GetMapping({"/{key}"})
    public String get(@PathVariable("key") K key, ModelMap model) {
        return this.model(OptType.VIEW.toString(), key, model);
    }

    @RequestMapping({"/model/{optType}", "/model/{key}/{optType}"})
    public String model(@PathVariable(required = false, name = "optType") String optType,
                        @PathVariable(required = false, name = "key") K key,
                        ModelMap model) {
        if (key == null || OptType.ADD.toString().equals(optType)) {
            model.addAttribute("beandData", emptyBean());
            model.addAttribute("beandOptType", OptType.ADD);
        } else {
            model.addAttribute("beandData", getService().get(key));
            model.addAttribute("beandOptType", OptType.valueOf(optType));
        }
        return pre() + "/model";
    }

    /**
     * 更新
     * @param param
     * @param model
     * @param optType
     * @return
     */
    @PostMapping("/post")
    public String post(T param, ModelMap model, OptType optType) {
        try {
            T rstBean = getService().update(param);
            model.addAttribute("beandData", rstBean);
            model.addAttribute("message", "修改成功");
            model.addAttribute("operationResult", OPERATION_SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("beandData", model);
            model.addAttribute("message", "修改失败: " + e.getMessage());
            model.addAttribute("operationResult", OPERATION_FAILED);
        }
        model.addAttribute("beandOptType", OptType.UPDATE);
        return pre() + "/model";
    }

    /**
     * 新增
     * @param param
     * @param model
     * @return
     */
    @PostMapping("/put")
    public String put(T param, ModelMap model) {
        try {
            T rstBean = getService().add(param);
            model.addAttribute("beandData", rstBean);
            model.addAttribute("message", "新增成功");
            model.addAttribute("operationResult", OPERATION_SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("beandData", model);
            model.addAttribute("message", "新增失败: " + e.getMessage());
            model.addAttribute("operationResult", OPERATION_FAILED);
        }
        model.addAttribute("beandOptType", OptType.ADD);
        return pre() + "/model";
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable("key") K key, ModelMap model) {
        T rstBean = getService().delete(key);
        model.addAttribute("beandData", rstBean);
        model.addAttribute("beandOptType", OptType.DELETE);
        return pre() + "/list";
    }

    @RequestMapping(value = "/page")
    public String page(T param, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, ModelMap model) {
        model.addAttribute("pageData", new PageInfo<T>(getService().find(param, pageNo - 1, pageSize)));
        return pre() + "/list";
    }

    public abstract BaseService<T, K> getService();

    public abstract String pre();

    public abstract Object emptyBean();

    public static enum OptType {
        VIEW, ADD, UPDATE, DELETE
    }

}
