package com.kiwi.controller;

import com.alibaba.fastjson.JSONObject;
import com.kiwi.dao.StoreDao;
import com.kiwi.service.StoreService;
import com.kiwi.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired(required = false)
    private StoreDao storeDao;

    @RequestMapping(value = "fillFruitList.do")
    @ResponseBody
    public void fillFruitList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.info("--------获取商品列表--------开始");
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
        log.info("--------获取商品列表--------结束");
    }


    @RequestMapping(value = "getFruitDetail.do")
    @ResponseBody
    public void getFruitDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.info("--------获取商品详情--------开始");
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
        log.info("--------获取商品详情--------结束");
    }

    @RequestMapping(value = "uploadImg.do")
    @ResponseBody
    public void uploadImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("--------上传图片--------开始");
        try {
            String fruitId = request.getHeader("id");
            String urlList = "";
            for(String url : Tools.uploadFile(request)){
                urlList += StringUtils.hasLength(urlList) ? "," + url : url;
            }
            this.storeDao.updateFruitImage(fruitId, urlList);
        } catch (Exception e){
            e.printStackTrace();
        }
        log.info("--------上传图片--------结束");
    }

    @RequestMapping(value = "saveFruitInfo.do")
    @ResponseBody
    public void saveFruitInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("--------更改商品信息--------开始");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        String param = request.getParameter("param");
        log.info("[param]>>>" + param);
        JSONObject json = JSONObject.parseObject(param);

        PrintWriter out = response.getWriter();
        out.print(this.storeService.saveFruitInfo(json));
        out.flush();
        out.close();
        log.info("--------更改商品信息--------结束");
    }

    @RequestMapping(value = "getUnitMenu.do")
    @ResponseBody
    public void getUnitMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("--------获取单位菜单--------开始");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
//        String param = request.getParameter("param");
//        log.info("[param]>>>" + param);
//        JSONObject json = JSONObject.parseObject(param);

        PrintWriter out = response.getWriter();
        out.print(this.storeService.getUnitMenu());
        out.flush();
        out.close();
        log.info("--------获取单位菜单--------结束");
    }

}
