package com.kiwi.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by kiwi on 2017/2/15.
 */
public interface StoreDao extends DaoMapper {

    public List<JSONObject> selectStoreList(JSONObject json);
}
