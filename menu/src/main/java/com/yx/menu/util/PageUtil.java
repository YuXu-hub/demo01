package com.yx.menu.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 * Created by progr on 2019/11/15.
 */
public class PageUtil<T> implements Serializable {

    private Integer page;//当前页
    private Integer pre;//上一页
    private Integer next;//下一页
    private Integer totalPage;//尾页
    private Long total;//总记录数
    private List<T> rows;//当前页记录
    private Integer size = 3;//分页单位 默认为3
    //一定要有无参构造
    public PageUtil() {
    }

    //构造方法 没传size
    public PageUtil(Integer page, Long total, List<T> rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
        //总页数
        int t  = (int) (total/size);//有多少页
        this.totalPage = total%size>0?t+1:t;
        //上一页
        this.pre = page>1?page-1:1;
        //下一页
        this.next = page<totalPage?page+1:totalPage;
    }
    //指定分页单位
    public PageUtil(Integer page, Long total, List<T> rows,int size) {
        this.page = page;
        this.total = total;
        this.rows = rows;
        //总页数
        int t  = (int) (total/size);//有多少页
        this.totalPage = total%size>0?t+1:t;
        //上一页
        this.pre = page>1?page-1:1;
        //下一页
        this.next = page<totalPage?page+1:totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
