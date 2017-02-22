package com.kiwi.controller;

import com.alibaba.fastjson.JSONObject;
import com.kiwi.service.StoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by kiwi on 2017/2/15.
 */
@Controller
public class Store {

    private Logger log = Logger.getLogger(Store.class);

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "fillFruitList.do")
    @ResponseBody
    public void fillFruitList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        String param = request.getParameter("param");
        log.info("[param]>>>" + param);
        JSONObject json = JSONObject.parseObject(param);

        PrintWriter out = response.getWriter();
        out.print(this.storeService.getStoreList(json));
        out.flush();
        out.close();
    }


    @RequestMapping(value = "getFruitDetail.do")
    @ResponseBody
    public void getFruitDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        String param = request.getParameter("param");
        log.info("[param]>>>" + param);
        JSONObject json = JSONObject.parseObject(param);

        PrintWriter out = response.getWriter();
        out.print(this.storeService.getStoreDetail(json));
        out.flush();
        out.close();
    }

}
