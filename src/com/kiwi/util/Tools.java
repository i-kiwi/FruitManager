package com.kiwi.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kiwi on 2017/1/9.
 */
public class Tools {

    /**
     * 读取配置文件
     * @param key
     * @return
     */
    public static String getString(String key){
        InputStream in = Tools.class.getClassLoader().getResourceAsStream("conf.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        } catch (Exception e){
            e.printStackTrace();
        }
        return p.getProperty(key);
    }
}
