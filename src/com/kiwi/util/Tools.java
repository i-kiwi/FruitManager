package com.kiwi.util;

import com.alibaba.fastjson.JSONObject;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kiwi on 2017/1/9.
 */
public class Tools {

    public static String formatReturnInfo(String info, String msg, String item){
        JSONObject json = new JSONObject();
        json.put("info", info);
        json.put("msg", msg);
        json.put("item", item);
        return json.toJSONString();
    }
}
