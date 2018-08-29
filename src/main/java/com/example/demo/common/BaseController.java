package com.example.demo.common;

import com.example.demo.common.constants.ResponseCode;
import com.example.demo.common.entity.AjaxJSON;
import com.example.demo.common.entity.JSONResult;

public abstract class BaseController {

    /**
     * 返回结果，统一由BaseController返回给前端数据
     * JSONResule 只做数据处理
     */
    public AjaxJSON ajaxResult(JSONResult jsonResult) {
        AjaxJSON json = new AjaxJSON();
        if (jsonResult != null) {
            json.setCode(jsonResult.getCode());
            json.setData(jsonResult.getData());
            json.setMsg(jsonResult.getMsg());
            json.setSuccess(jsonResult.getSuccess());
        }
        return json;
    }

    /**
     * 返回成功结果，jsonResult为任意实体
     */
    public AjaxJSON successResult(JSONResult jsonResult) {
        AjaxJSON json = new AjaxJSON();
        json.setCode(jsonResult.getCode());
        json.setData(jsonResult);
        json.setMsg(jsonResult.getMsg());
        json.setSuccess(true);
        return json;
    }

    /**
     * 返回失败结果，jsonResult为任意实体
     */
    public AjaxJSON failResult(JSONResult jsonResult) {
        AjaxJSON json = new AjaxJSON();
        json.setData(jsonResult);
        json.setSuccess(false);
        if (jsonResult == null) {
            json.setMsg("失败");
            json.setCode(ResponseCode.CODE_FINAL);
        } else {
            json.setMsg(jsonResult.getMsg());
            json.setCode(jsonResult.getCode());
        }
        return json;
    }

}
