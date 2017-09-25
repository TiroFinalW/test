package com.jielan.model.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang on 2016/12/15.
 */
/**
 * 分页查询模型类
 */
public class PageQuery {
    private static final long serialVersionUID = 1L;

    /** 每页记录条数，默认20 **/
    private int    pagesize = 20;

    /** 页码索引，默认为1 **/
    private int    pageindex=1;

    /** 总记录条数 **/
    private int  recordcount;

    /** 排序语句 **/
    private String orderby;
    /** 页码索引，默认为1 **/
    private boolean pageFlg = true;
    private String desc;
    private int pagestart;
    private String pageend;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        if (pagesize > 0) {
            this.pagesize = pagesize;
        }
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        if (pageindex > 0) {
            this.pageindex = pageindex;
        }
    }

    public int getRecordcount() {
        return recordcount;
    }

    public void setRecordcount(int recordcount) {
        this.recordcount = recordcount;
    }

    public int getPagecount() {
        if (recordcount < 1) {
            return 0;
        }
        if (recordcount % pagesize > 0) {
            return recordcount / pagesize + 1;
        } else {
            return recordcount / pagesize;
        }
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public int getPagestart() {
        return (this.pageindex - 1) * this.pagesize;
    }

    public int getPageend() {
        return this.pageindex * this.pagesize;
    }

    /**
     * 获得 pageFlg
     * @return  the pageFlg
     */

    public boolean isPageFlg() {
        return pageFlg;
    }

    /**
     * @param pageFlg the pageFlg to set
     */
    public void setPageFlg(boolean pageFlg) {
        this.pageFlg = pageFlg;
        //不分页，但有些是轮询分批 获取信息的。为了不调用查询总数， 囧~~
        if(!pageFlg &&  pagesize == 15){
            pagesize=Integer.MAX_VALUE;
        }
    }

    /**
     * 获得 desc
     * @return  the desc
     */

    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
