package com.ouyang.study.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ouyangxu
 * @Date: 2019年05月09日 18:55
 */
public class NoticePushDTO {
    /**
     * 功能模块
     */
    private String module;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 模板字段
     */
    private Map<String, String> data;

    /**
     * 指定推送方式
     */
    private List<PushMethodDTO> methods;

    public static NoticePushDTO build() {
        return new NoticePushDTO();
    }

    public NoticePushDTO addModule(String module) {
        this.module = module;
        return this;
    }

    public NoticePushDTO addUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public NoticePushDTO addData(String key, String value) {
        if (this.data == null) {
            this.data = new HashMap<>();
        }
        this.data.put(key, value);
        return this;
    }

    public NoticePushDTO addData(Map<String, String> data) {
        this.data =data;
        return this;
    }

    public NoticePushDTO addMethod(PushMethodDTO method) {
        if (this.methods == null) {
            this.methods = new ArrayList<>();
        }
        this.methods.add(method);
        return this;
    }

    public NoticePushDTO addMethods(List<PushMethodDTO> methods) {
        this.methods = methods;
        return this;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public List<PushMethodDTO> getMethods() {
        return methods;
    }

    public void setMethods(List<PushMethodDTO> methods) {
        this.methods = methods;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"module\":\"")
                .append(module).append('\"');
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"data\":")
                .append(data);
        sb.append(",\"methods\":")
                .append(methods);
        sb.append('}');
        return sb.toString();
    }
}
