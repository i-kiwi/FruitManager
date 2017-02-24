package com.kiwi.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kiwi on 2017/2/15.
 */
public interface StoreDao extends DaoMapper {

    public List<JSONObject> selectStoreList(JSONObject json);

    public JSONObject selectFruitDetail(String fruitId);

    public void updateFruitImage(@Param("fruitId") String fruitId, @Param("imgList") String imgList);

    public void updateFruitInfo(JSONObject json);

    public List<JSONObject> selectUnitMenu();
}
