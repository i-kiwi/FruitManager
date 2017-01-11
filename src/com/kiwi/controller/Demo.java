package com.kiwi.controller;

import com.kiwi.dao.RedisBaseDao;
import com.kiwi.dao.UserDao;
import com.kiwi.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kiwi on 2017/1/9.
 */
@Controller
public class Demo {

    @Autowired
    private RedisBaseDao redis;

    @Autowired(required = false)
    private UserDao userDao;

    @RequestMapping("tt.do")
    @ResponseBody
    public String tt(){
        return "hello," + userDao.findName() ;
    }
}
