import com.jielan.dao.SendMsgMapper;
import com.jielan.util.SmsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class SendMsgJunit {

    @Autowired
    private SendMsgMapper mapper;

//   @Test
    public void sendMsg(){
        List<Map<String,Object>> userlist =mapper.sendUser();
        List<Map<String,String>> quanlist = mapper.sendQuan();
        int i=0;
        for(Map<String,Object> map:userlist){
            System.out.println(map.get("phone")+"***"+map.get("number"));
            for(int j = 0; j<Integer.parseInt(map.get("number").toString()); j++){
                System.out.println("手机"+(String) map.get("phone")+",发送次数"+map.get("number")+",第"+(i+1)+"条，兑换码:"+quanlist.get(i).get("quanpwd")+"有效期:"+quanlist.get(i).get("deadline"));

//                    SmsUtil.sendSms((String) map.get("phone"),"【果麦】电子水果券验证码："+quanlist.get(i).get("quanpwd")+"，每个密码面值5元。凭密码可在全省果麦合作门店兑换等值水果，门店详情登录 www.gmquan.cn 查询 。" +
//                            "该券不找零，不兑现，不与其它优惠同享（包括会员卡），有效期"+quanlist.get(i).get("deadline")+"，客服电话：0571-85808891。（湖州移动签到送好礼活动）");
                SmsUtil.sendSms((String)map.get("phone"),"尊敬的客户，您的一鸣真鲜奶吧券券码{"+quanlist.get(i).get("quanpwd")+"}，每个券码面值5元。凭券码可在一鸣真鲜奶吧门店抵现使用，该券不找零、不兑现、可叠加使用，" +
                        "也可与其他优惠券叠加使用，有效期到"+quanlist.get(i).get("deadline")+"。详询12580【湖州移动签到送好礼活动】");
               i++;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           }
        }
      //      System.out.println(map.get("quanname")+"***"+map.get("quanpwd")+"***"+map.get("deadline"));
        }
        @Test
        public void sendMsg1(){
            SmsUtil.sendSms("15757155124","尊敬的客户，您的一鸣真鲜奶吧券券码{10125515909，每个券码面值5元。凭券码可在一鸣真鲜奶吧门店抵现使用，该券不找零、不兑现、可叠加使用，" +
                       "也可与其他优惠券叠加使用，有效期到20170531。详询12580【湖州移动签到送好礼活动】");
        }
    }

