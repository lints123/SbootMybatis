package com.example.demo.common.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;

public class JsonUtil {

    public static JSONObject dealWithNull(Object json){
        if(json instanceof ArrayList || json instanceof JSONArray){
            return (JSONObject)JSONArray.fromObject(JSONArray.fromObject(json).toString().replace(":null", ":\"\"")).toArray()[0];
        }
        return JSONObject.fromObject(JSONObject.fromObject(json).toString().replace(":null", ":\"\""));
    }
}
