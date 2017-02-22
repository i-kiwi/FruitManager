package com.kiwi.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by kiwi on 2017/1/9.
 */
public class Tools {

    private static Logger log = Logger.getLogger(Tools.class);
    private static ServletFileUpload upload;
    private static Random random = new Random();

    private static SimpleDateFormat fullSdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String formatReturnInfo(String info, String msg, String item){
        JSONObject json = new JSONObject();
        json.put("info", info);
        json.put("msg", msg);
        json.put("item", item);
        log.debug(json.toJSONString());
        return json.toJSONString();
    }

    public static String getRandom(){
        return ("" + random.nextDouble()).substring(2, 8);
    }



    public static List<String> uploadFile(HttpServletRequest request) throws Exception{
        FileItemFactory factory = new DiskFileItemFactory();
        upload = new ServletFileUpload(factory);
        upload.setSizeMax(4194304 * 2L);

        String path = "";
        String name = "";
        String url = "";
        List<String> fileNames = new ArrayList<String>();
        List<FileItem> items = upload.parseRequest(request);
        if(items != null && !items.isEmpty()){
            for (FileItem item : items){
                if(item.getSize() == 0){
                    continue;
                }
                String[] originalName = item.getName().split("\\.");
                path = PropertyUtil.getConstants("filePath");
                name = request.getHeader("id") + fullSdf.format(new Date()) + getRandom() + "." + originalName[originalName.length - 1];
                url = PropertyUtil.getConstants("fileUrl");
                fileNames.add(name);

                File file = new File(path + name);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                InputStream is = item.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                FileOutputStream fos = new FileOutputStream(file);
                int f;
                while((f = bis.read()) != -1){
                    fos.write(f);
                }
                fos.flush();
                fos.close();
                bis.close();
                is.close();
            }
        }
        return fileNames;
    }


}
