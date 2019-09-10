package com.hb.userroles.define;

import java.io.Serializable;
import java.util.Map;

public class WebResponse implements Serializable {
    private boolean success = true;// 是否成功
    private String msg = "操作成功";// 提示信息
    private Object obj = null;// 其他信息
    private Integer code = 200;// code编码
    private Map<String, Object> attributes;// 其他参数

    public static WebResponse successReponse(String message){
        WebResponse rst = instance();
        rst.success = true;
        rst.msg = message;
        return rst;
    }

    public static WebResponse instance(){
        return new WebResponse();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
