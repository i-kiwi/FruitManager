package com.kiwi.dao;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by kiwi on 2017/1/11.
 */
public interface UserDao extends DaoMapper{

    public String findName();

    public String login(JSONObject json);
}
