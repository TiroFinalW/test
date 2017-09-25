import com.alibaba.fastjson.JSONObject;
import com.jielan.util.HttpUtil;
import com.jielan.util.WeChatUtil;

import java.io.IOException;

/**
 * Created by wang on 2016/12/13.
 */
public class test {
    public static void main(String[] args) throws IOException {
        String json = HttpUtil.get("http://manage.jielanwx.com/inter_BaseFunc_findWcUser.html?openId=ogRaqtysEsRGIOXC9WQNKwuePE08&initialId=gh_c9e42f4d6ef5");
        JSONObject obj = JSONObject.parseObject(json);
        String resultCode = obj.getString("resultCode");
        System.out.println(WeChatUtil.getUserInfo("ogRaqtwXPRScFYJvkjy1DhEnvnOA").getString("nickname"));
        if("200".equals(resultCode)){
            String resultContent = obj.getString("resultContent");
            JSONObject contentjson = JSONObject.parseObject(resultContent);
            String mobile = contentjson.getString("phone");
            System.out.println(mobile);
        }else{

        }
        //http://jhdt.jielanwx.com/hz/winthebill/?openid=ogRaqtysEsRGIOXC9WQNKwuePE08&toUserName=gh_c9e42f4d6ef5
        String openid = "ogRaqt0zbvShmG5qcILgQQ7IT8Bk";
        System.out.println(WeChatUtil.getUserInfo(openid).getString("headimgurl")+"......"+WeChatUtil.getUserInfo(openid).getString("nickname"));

        System.out.println("手机"+WeChatUtil.getPhone("ogRaqtyo0C2BCADrZleiJpOQQdXo"));
    }
}
