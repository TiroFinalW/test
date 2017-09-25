package com.jielan.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wang on 2016/12/20.
 */
  public class DateUtil {
        private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

        private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
                "yyyy-MM-dd");

        private final static SimpleDateFormat sdfDay2 = new SimpleDateFormat(
                "MM-dd");

        private final static SimpleDateFormat sdfDay3 = new SimpleDateFormat(
                "dd");

        private final static SimpleDateFormat sdfMonth= new SimpleDateFormat(
                "MM");

        private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
                "yyyyMMdd");

        private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        /**
         * 获取YYYY格式
         *
         * @return
         */
        public static String getYear() {
            return sdfYear.format(new Date());
        }

        /**
         * 获取MM格式
         * @return
         */
        public static String getMonth(){
            return sdfMonth.format(new Date());
        }

        /**
         * 获取dd格式
         * @return
         */
        public static String getDay3(){
            return sdfDay3.format(new Date());
        }


        /**
         * 获取YYYY-MM-DD格式
         *
         * @return
         */
        public static String getDay() {
            return sdfDay.format(new Date());
        }

        /**
         * 获取MM-DD格式
         *
         * @return
         */
        public static String getDay2() {
        return sdfDay2.format(new Date());
    }

        /**
         * 获取YYYYMMDD格式
         *
         * @return
         */
        public static String getDays(){
            return sdfDays.format(new Date());
        }

        /**
         * 获取YYYY-MM-DD HH:mm:ss格式
         *
         * @return
         */
        public static String getTime() {
            return sdfTime.format(new Date());
        }


        /**
         * @Title: compareDate
         * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
         * @param s
         * @param e
         * @return boolean
         * @throws
         * @author luguosui
         */
        public static boolean compareDate(String s, String e) {
            if(fomatDate(s)==null||fomatDate(e)==null){
                return false;
            }
            return fomatDate(s).getTime() >=fomatDate(e).getTime();
        }

        public static int compareDateTime(String s, String e) throws ParseException {
            if(sdfTime.parse(s).getTime()>sdfTime.parse(e).getTime()){
                return 1;
            }else if(sdfTime.parse(s).getTime()==sdfTime.parse(e).getTime()){
                return 0;
            }else{
                return -1;
            }
        }

        /**
         * 格式化日期
         *
         * @return
         */
        public static Date fomatDate(String date) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return fmt.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * 格式化日期
         *
         * @return
         */
        public static Date fomatDate1(String date) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return fmt.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

          /**
         * 自定义天 wang
         */
          public static Date setDate(int day){
              Calendar calendar = Calendar.getInstance();
              calendar.set(Calendar.DAY_OF_MONTH, day);
              calendar.set(Calendar.HOUR_OF_DAY, 0);
              calendar.set(Calendar.MINUTE, 0);
              calendar.set(Calendar.SECOND, 0);
              return calendar.getTime();
          }

    /**
     * 获取某个日子 日期 wang
     */
    public static String getSomeDay(Date date){
        return sdfDay3.format(date);
    }
    /**
     * 将某个日期转成 yyyy-MM-dd  wang
     */
    public static String getStringDay(Date date){
        return sdfDay.format(date);
    }

    /**
     * wang

     */
    public static String getMMddDay(Date date){
        return sdfDay2.format(date);
    }



    /**
     * 校验日期是否合法
         *
         * @return
         */
        public static boolean isValidDate(String s) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                fmt.parse(s);
                return true;
            } catch (Exception e) {
                // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
                return false;
            }
        }
        public static int getDiffYear(String startTime,String endTime) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
                return years;
            } catch (Exception e) {
                // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
                return 0;
            }
        }
        /**
         * <li>功能描述：时间相减得到天数
         * @param beginDateStr
         * @param endDateStr
         * @return
         * long
         * @author Administrator
         */
        public static long getDaySub(String beginDateStr,String endDateStr){
            long day=0;
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date beginDate = null;
            java.util.Date endDate = null;

            try {
                beginDate = format.parse(beginDateStr);
                endDate= format.parse(endDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);

            return day;
        }

    public static long getDaySub(Date endDate,Date beginDate){
        long day=0;
        day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
        return day;
    }


        /**
         * 得到n天之后的日期
         * @param days
         * @return
         */
        public static String getAfterDayDate(String beginDate,String days) {
            int daysInt = Integer.parseInt(days);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fomatDate(beginDate));

            calendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
            Date date = calendar.getTime();

            SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdfd.format(date);

            return dateStr;
        }

        /**
         * 得到n天之后的日期(无需完整格式)
         * @param days
         * @return
         */
        public static String getAfterDay(String beginDate,String days) {
            int daysInt = Integer.parseInt(days);
            String datePre=DateUtil.getYear()+"-"+DateUtil.getMonth()+"-";
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fomatDate(datePre+beginDate));

            calendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
            Date date = calendar.getTime();

            SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdfd.format(date);
            String dateStrPre=dateStr.substring(0, dateStr.lastIndexOf("-")+1);
            String datrStrAf=dateStr.substring(dateStr.lastIndexOf("-")+1, dateStr.length());
            int t=Integer.parseInt(datrStrAf);
            // if((t+"").length()==1){
            //	datrStrAf="0"+datrStrAf;
            // }
            return datrStrAf;
        }

        /**
         * 得到n天之前的日期
         * @param beginDate
         * @param days
         * @return
         */
        public static String getBeforeDay(String beginDate,String days) {
            int daysInt = Integer.parseInt(days);
            String datePre=DateUtil.getYear()+"-"+DateUtil.getMonth()+"-";
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fomatDate(datePre+beginDate));

            calendar.add(Calendar.DATE, -daysInt); // 日期减 如果不够减会将月变动
            Date date = calendar.getTime();

            SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdfd.format(date);
            String dateStrPre=dateStr.substring(0, dateStr.lastIndexOf("-")+1);
            String datrStrAf=dateStr.substring(dateStr.lastIndexOf("-")+1, dateStr.length());
            int t=Integer.parseInt(datrStrAf);
            // if((t+"").length()==1){
            //	datrStrAf="0"+datrStrAf;
            // }
            return datrStrAf;
        }


        /**
         * 得到n天之后的日期
         * @param days
         * @return
         */
        public static String getBeforeDayDate(String beginDate,String days) {
            int daysInt = Integer.parseInt(days);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fomatDate(beginDate));

            calendar.add(Calendar.DATE, -daysInt); // 日期减 如果不够减会将月变动
            Date date = calendar.getTime();

            SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdfd.format(date);

            return dateStr;
        }


        /**
         * 得到n天之后的时间
         * @param days
         * @return
         */
        public static String getAfterDayTime(String beginDate,String days) {
            int daysInt = Integer.parseInt(days);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fomatDate1(beginDate));

            calendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
            Date date = calendar.getTime();
            return sdfTime.format(date);
        }

        /**
         * 得到n天之后是周几
         * @param days
         * @return
         */
        public static String getAfterDayWeek(String days) {
            int daysInt = Integer.parseInt(days);

            Calendar canlendar = Calendar.getInstance(); // java.util包
            canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
            Date date = canlendar.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("E");
            String dateStr = sdf.format(date);

            return dateStr;
        }

        /**
         * 得到n天之后是周几
         * @return
         */
        public static String getAfterYear(String years) {
            int yearsInt = Integer.parseInt(years);

            Calendar canlendar = Calendar.getInstance(); // java.util包
            canlendar.add(Calendar.YEAR, yearsInt); // 日期减 如果不够减会将月变动
            Date date = canlendar.getTime();

            String dateStr = sdfTime.format(date);

            return dateStr;
        }

        /**
         * 获取上个月的总天数
         * @return
         */
        public static int getLastMonthMaxDay(){

            Calendar cal1 = Calendar.getInstance();
            cal1.set(Calendar.DAY_OF_MONTH, 1);
            cal1.add(Calendar.DAY_OF_MONTH, -1);

            return cal1.get(Calendar.DAY_OF_MONTH);
        }

        /**
         * 获取这个月的总天数
         */
        public static int getMaxDay(){
            java.util.Calendar cal = java.util.Calendar.getInstance();
            int maxDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
            return maxDay;
        }


        /**
         * 获取上个月
         */
        public static String getLastMonth(){
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -1);
            String lastMonth=new SimpleDateFormat("MM").format(c.getTime());
            return lastMonth;
        }

        /**
         *获取下个月
         */
        public static String getNextMonth(){
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 1);
            String nextMonth=new SimpleDateFormat("MM").format(c.getTime());
            return nextMonth;
        }

        /**
         * 获取明年
         */
        public static String getNextYear(){
            Calendar c = Calendar.getInstance();
            c.add(Calendar.YEAR, 1);
            String nextYear=new SimpleDateFormat("yyyy").format(c.getTime());
            return nextYear;
        }

        /**
         * 获取n个月后的最后一天
         * @param
         */
        public static String getAfterMonth(int month){
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, 0);
            String AfterSinMonth=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            //getAfterSinMonth+=DateUtil.getMaxDay();
            return AfterSinMonth;
        }

        /**
         * 根据年 月 获取对应的月份 天数
         * */
        public static int getDaysByYearMonth(int year, int month) {

            Calendar a = Calendar.getInstance();
            a.set(Calendar.YEAR, year);
            a.set(Calendar.MONTH, month - 1);
            a.set(Calendar.DATE, 1);
            a.roll(Calendar.DATE, -1);
            int maxDate = a.get(Calendar.DATE);
            return maxDate;
        }

        /**
         * 根据给定的时间区域 返回该区域内的所有时间
         * @return
         */
        public static List<String> getAllDay(String startime, String endtime){
            long balnkDay=DateUtil.getDaySub(startime, endtime);
            List<String> datList=new ArrayList<String>();

            for(int i=0;i<=balnkDay;i++){
                datList.add(DateUtil.getAfterDayDate(startime, i+""));
            }

            return datList;
        }
    /**
     * 根据给定的时间区域 返回该区域内的所有时间 倒序
     * @return
     */
    public static List<String> getAllDay1(String startime, String endtime){
        long balnkDay=DateUtil.getDaySub(endtime, startime);
        List<String> datList=new ArrayList<String>();

        for(int i=0;i<=balnkDay;i++){
            datList.add(DateUtil.getBeforeDayDate(endtime, i+""));
        }

        return datList;
    }

        /**
         * 根据二分法查找一个连续日期区间中指定日期的位置
         * @param datList  日期区间
         * @param date2  指定的日期
         * @return re
         */
        public static int findDate(List<String> datList,String date2){
    	/*
    	 * 思路：
    	 * 指定时间为t，指定区间为t1
    	 * 取出区间的首尾值s和e
    	 * 取出s和e的中间值m
    	 * 如果
    	 * 		m>t
    	 * 那么
    	 * 		取出s和m的中间值m1
    	 *依次比较，取出位置
    	 *
    	 */
            long re=0;//返回值
            int isCon=1;//是否继续

            String firstDate=datList.get(0);
            String lastDate=datList.get(datList.size()-1);

            //首先判断特定值是否大于首且小于尾

            //判断位置
            while(isCon!=0){
                String d="0";
                String m="0";
                d=DateUtil.getDaySub(firstDate, lastDate)/2+"";//首尾之间相隔多少天
                m=DateUtil.getAfterDayDate(firstDate, d);//新生成的中间时间
                if(m.equals(date2)){
                    re=Integer.parseInt(d);
                    isCon=0;
                }else{
                    if(DateUtil.compareDate(date2, m)){
                        //date2大于m
                        firstDate=m;
                    }else{
                        //date2小于m
                        lastDate=m;
                    }
                }
            }

            //String m=DateUtil.getAfterDayDate(firstDate, (DateUtil.getDaySub(firstDate, lastDate)/2)+"");

            return Integer.parseInt(re+"");
        }


        public static  List<Integer> getAllInt(int startInt,int endInt){
            List<Integer> iList=new ArrayList<Integer>();
            for (int i = 0; i<=endInt; i++) {
                iList.add(i);
            }
            return iList;
        }


    /**
         * 二分法查询数据位置
         * @param list
         * @param i
         * @return
         */
        public static int getIntPos(List<Integer> list,int i){
            boolean isCon=true;//是否继续
            int pos=-1;//位置
            int s=list.get(0);
            int e=list.get(list.size()-1);
            int k=0;//统计循环的次数
            while(isCon){
                int d=0;
                d=(s+e)/2;//中间数的位置
                if(i==d){
                    pos=d;
                    isCon=false;
                }else{
                    if(i>d){
                        s=d;
                    }else{
                        e=d;
                    }
                }
                k++;
            }
            return k;
        }

    /**
     * 判断是否是周末 节假日  wang
     * @return
     */
    public static int dayCheck(Date now ){
        int i=0;//都不是

        Calendar c = Calendar.getInstance();
        int num = c.get(Calendar.DAY_OF_WEEK) - 1;
        if(num==0||num==6){
            i=1;//是周末
        }

        String[] holidays = {"2017-01-28","2017-01-29","2017-01-27","2017-04-04","2017-05-01","2017-05-30","2017-10-01",
                "2017-10-02","2017-10-03","2017-10-04","2018-02-16","2018-02-17","2018-02-18","2018-04-05","2018-05-01","2018-06-28"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(now);
        System.out.println(today);
        for(String holiday:holidays){
            if(holiday.equals(today)){
                i = 2; //是节假日
            }
        }
        return i;
    }

    /**
     *判断现在是否是今天某个时间段 wang
     */
    public static boolean hourCheck(int start,int end){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, start);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, end);
        Date endDate = calendar.getTime();
        if(date.after(startDate)&&date.before(endDate)){
            return true;
        }else{
            return false;
        }
    }

        public static void main(String[] args) throws ParseException {
            String startdate="2016-01-01";
            String enddate="2016-12-31";
            String date2="2016-11-02";

            long t1=System.nanoTime();
            List<String> inteDay=DateUtil.getAllDay(startdate,enddate);
            long t2=System.nanoTime();
            System.out.println("生成数组的大小为:"+inteDay.size()+",时间为:"+(t2-t1));

            int pos=inteDay.indexOf(date2);

            long t3=System.nanoTime();
            System.out.println(pos);
            System.out.println("查找花费的时间为:"+(t3-t2));

            String today = DateUtil.getDay3();
            System.out.println(today);
            int num = DateUtil.getMaxDay();
            String[] arr1 = {"19","2","21"};
            if(Arrays.asList(arr1).contains(today)){
                System.out.println("包含");
            }
            System.out.println(setDate(1));
            System.out.println("****"+getDaySub("2015-5-9","2015-5-10"));
            System.out.println(compareDate("2015-5-9","2015-5-5"));
            System.out.println("****"+getDaySub("2015-5-9","2015-5-9"));
            System.out.println(hourCheck(15,16));
            System.out.println(dayCheck(new Date()));
            System.out.println(getDaySub(fomatDate("2016-12-26"),fomatDate("2016-12-25")));
            System.out.println(new Date(new Date().getTime()-1000*24*60*60));
            System.out.println(getAfterDayDate("2016-12-26","1"));
            System.out.println(getMMddDay(new Date()));
            System.out.println("月初"+DateUtil.fomatDate(new SimpleDateFormat("yyyy-MM").format(new Date())+"-01"));
        }

    }
