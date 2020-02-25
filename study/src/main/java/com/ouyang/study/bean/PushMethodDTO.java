package com.ouyang.study.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ouyangxu
 * @Date: 2019年05月17日 14:54
 */
public class PushMethodDTO {
    /**
     * 推送方式
     */
    private String method;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 模板字段
     */
    private Map<String, String> data;

    public PushMethodDTO build() {
        return new PushMethodDTO();
    }

    public PushMethodDTO addMethod(String method) {
        this.method = method;
        return this;
    }

    public PushMethodDTO addUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public PushMethodDTO addData(String key, String value) {
        if (this.data == null) {
            this.data = new HashMap<>();
        }
        this.data.put(key, value);
        return this;
    }

    public PushMethodDTO addData(Map<String, String> data) {
        this.data =data;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"method\":\"")
                .append(method).append('\"');
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }
}
