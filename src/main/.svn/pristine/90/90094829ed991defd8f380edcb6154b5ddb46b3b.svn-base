package com.jielan.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by wang on 2016/12/20.
 * 文件上传工具类
 */
public class FileuploadUtil {

    public static String fileUpload(HttpServletRequest request, MultipartFile file){
        String filePath="";//保存文件路径
        String fileName = "";// 文件后缀名
        String rootPath = "";//根目录
        try {
                 fileName = new Date().getTime()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); //时间戳命名
                 filePath = request.getSession().getServletContext().getRealPath("/").replace("\\", "/") + "upload"+File.separator +fileName; //要存储的文件名
                rootPath = request.getSession().getServletContext().getRealPath("/").replace("\\", "/");
                if(!new File(rootPath+ "upload").exists()){ //upload文件夹不存在则创建
                    new File(rootPath+ "upload").mkdir();
                }
                    FileInputStream in = (FileInputStream) file.getInputStream();
                    FileOutputStream out = new FileOutputStream(filePath);
                     int len = 0;
                      byte buffer[] = new byte[1024];
                      while((len=in.read(buffer))>0){
                        out.write(buffer, 0, len);
                     }
                     out.flush();
                     out.close();
                     in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload"+File.separator + fileName;
    }
}
