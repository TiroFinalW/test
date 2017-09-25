import com.jielan.model.SignRecord;
import com.jielan.util.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2016/12/22.
 */
public class test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("2016-12-27");
        list.add("2016-12-26");
        list.add("2016-12-25");
        list.add("2016-12-24");
        list.add("2016-12-23");
        list.add("2016-12-22");
        list.add("2016-12-21");
        list.add("2016-12-20");
        list.add("2016-12-19");
        list.add("2016-12-18");
        list.add("2016-12-15");
        list.add("2016-12-14");
        list.add("2016-12-13");
        list.add("2016-12-12");
        list.add("2016-12-11");

        long time1 = new Date().getTime();
        int count = maxsign1(DateUtil.getAllDay1("2017-11-20","2016-12-27"));
        long time2 = new Date().getTime();
        System.out.println("签到次数"+count);
        System.out.println("时间"+(time2-time1));

        List<Date> list1 = new ArrayList<Date>();
        list1.add(new Date(new Date().getTime()-1000*24*60*60*0)); // 29
        list1.add(new Date(new Date().getTime()-1000*24*60*60*1));  //28
        list1.add(new Date(new Date().getTime()-1000*24*60*60*2));//27
        list1.add(new Date(new Date().getTime()-1000*24*60*60*3));//26
        list1.add(new Date(new Date().getTime()-1000*24*60*60*4));  //25
        list1.add(new Date(new Date().getTime()-1000*24*60*60*5));//24
        list1.add(new Date(new Date().getTime()-1000*24*60*60*6));//23
        System.out.println(signoffDate(list1));
    }

    public static int maxsign1(List< String > list){
        String today = DateUtil.getDay();//今天日期
        long num=0;
        if(list!=null&&list.size()>1){
            String lastday =  list.get(0);
            num = DateUtil.getDaySub(lastday,today);
            System.out.println("最后一天和今天"+num);
            if(num>=0&&num<=1){  //最近签到是今天或者昨天
                int count = 1;
                for(int i=0;i<list.size()-1;i++){
                    String dayafter = list.get(i);
                    String daybefore = list.get(i+1);
                    if(DateUtil.getDaySub(daybefore,dayafter)==1){//相邻签到记录日期是否连续
                        count++;
                    }else {
                        break;
                    }
                }
                return  count;
            }

        }else if(list!=null&&list.size()==1){
            System.out.println("最后一天和今天***"+num);
            if(num>=0&&num<=1){
                return 1;
            }else{
                return 0;
            }

        }else {
            return 0;
        }
        return 0;
    }


    public static Date signoffDate(List<Date> list){
        String today = DateUtil.getDay();//今天日期
        long num=0;
        if(list!=null&&list.size()==1){

            String lastday =   DateUtil.getStringDay(list.get(0));
            num = DateUtil.getDaySub(lastday,today);
            if(num>=0&&num<=1){
                return new Date(list.get(0).getTime()-1000*24*60*60);//今天的前一天
            }else {
                return null;
            }

        }else if(list!=null&&list.size()>1){

            String lastday =   DateUtil.getStringDay(list.get(0));
            num = DateUtil.getDaySub(lastday,today); //今天和最晚签到一天的差值
            if(num>=0&&num<=1){  //最近签到是今天
                for(int i=0;i<list.size()-1;i++){
                    String dayafter = DateUtil.getStringDay(list.get(i));
                    String daybefore = DateUtil.getStringDay(list.get(i+1));
                    if(DateUtil.getDaySub(daybefore,dayafter)>1){//相邻签到记录日期不连续
                        return new Date(list.get(i).getTime()-1000*24*60*60); // 连续签到区间最早一天的前一天
                    }
                }
                return null; //签到记录全是连续的 不用补签
            }else {
                return new Date(new Date().getTime()-1000*24*60*60);//今天的前一天
            }

        }else {
            return null; //从来没签到 不需要补签
        }
    }
}
