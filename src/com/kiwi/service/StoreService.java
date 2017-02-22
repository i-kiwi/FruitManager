package com.kiwi.service;

import com.alibaba.fastjson.JSONObject;
import com.kiwi.dao.StoreDao;
import com.kiwi.util.PropertyUtil;
import com.kiwi.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kiwi on 2017/2/15.
 */
@Service
public class StoreService {

    private Logger log = Logger.getLogger(StoreService.class);

    @Autowired(required = false)
    private StoreDao storeDao;

    public String getStoreList(JSONObject json){
        String info = "";
        String msg = "";
        String item = "";
        try {
            List<JSONObject> list = this.storeDao.selectStoreList(json);
            info = "SUC";
            item = list.toString();
        } catch (Exception e){
            info = "ERR";
            msg = e.getMessage();
        }

        return Tools.formatReturnInfo(info, msg, item);
    }

    public String getStoreDetail(JSONObject json) {
        String info = "";
        String msg = "";
        String item = "";
        try {
            String fruitId = json.getString("fruitId");
            JSONObject resultJson = this.storeDao.selectFruitDetail(fruitId);
            resultJson.put("resourceUrl", PropertyUtil.getConstants("fileUrl"));
            info = "SUC";
            item = resultJson.toJSONString();
        } catch (Exception e){
            info = "ERR";
            msg = e.getMessage();
        }

        return Tools.formatReturnInfo(info, msg, item);
    }
}
