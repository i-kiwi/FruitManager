package com.kiwi.controller;

import com.alibaba.fastjson.JSONObject;
import com.kiwi.dao.UserDao;
import com.kiwi.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kiwi on 2017/2/15.
 */

@Controller
public class Login {

    private Logger log = Logger.getLogger(Login.class);

    @Autowired(required = false)
    private UserDao userDao;

    @RequestMapping("login.do")
    @ResponseBody
    public String login(HttpServletRequest request){
        String name = "";
        String param = request.getParameter("param");
        log.info(param);
        try {
            JSONObject json = JSONObject.parseObject(param);
            name = userDao.login(json);
        } catch (Exception e){
            e.printStackTrace();
        }
        return Tools.formatReturnInfo("SUC","", name);
    }
}
