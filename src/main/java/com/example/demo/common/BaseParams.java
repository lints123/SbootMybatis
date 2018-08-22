package com.example.demo.common;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

public class BaseParams {

    /**
     * 接收数据为：data:{name:zhangsan}
     */
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JSONObject getData2Json() {
        if (StringUtils.isBlank(data)) {
            JSONObject jsonObject = new JSONObject();
            return jsonObject;
        }
        try {
            return JSONObject.fromObject(data);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            return jsonObject;
        }
    }
}
