package com.jielan.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ClientProtocolException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by wang on 2016/12/13.
 * 微信工具类
 */
public class WeChatUtil{

    /**
     * 用于获取用户信息 头像 昵称 等；
     * @return
     */
    public static JSONObject getUserInfo(String openid) throws IOException {
        String userurl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+getAccessToken()+"&openid="+openid+"&lang=zh_CN";
        String result = HttpUtil.get(userurl);
        JSONObject obj = JSONObject.parseObject(result);
        return obj;
    }

    /**
     * 调用现成的接口 防止冲突
     */
    public static String getAccessToken() throws IOException {
        String tokenurl = "http://jhhd.jielanwx.com:8080/jhjk/hz_weixin";
        String tokenresult = HttpUtil.get(tokenurl);
        JSONObject obj = JSONObject.parseObject(tokenresult);
        String access_token = obj.getString("accesstoken");
        return  access_token;
    }

    /**
     * 查询用户绑定手机
     * @param openid
     */
    public static String getPhone(String openid) throws ClientProtocolException, IOException{
        String phone  = "";
        String json = HttpUtil.get("http://manage.jielanwx.com/inter_BaseFunc_findWcUser.html?openId="+openid+"&initialId=gh_c9e42f4d6ef5");
        JSONObject jb = JSONObject.parseObject(json);
        if(jb.getString("resultCode").equals("200")){
            String resultContent = jb.getString("resultContent");
            jb = JSONObject.parseObject(resultContent);
            phone = jb.getString("phone");
        }
        return phone;
    }
}
