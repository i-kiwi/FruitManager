package com.kiwi.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * Created by kiwi on 2017/1/9.
 */
public class Tools {

    private static Logger log = Logger.getLogger(Tools.class);

    public static String formatReturnInfo(String info, String msg, String item){
        JSONObject json = new JSONObject();
        json.put("info", info);
        json.put("msg", msg);
        json.put("item", item);
        log.debug(json.toJSONString());
        return json.toJSONString();
    }
}
