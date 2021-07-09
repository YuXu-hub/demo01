package com.yx.menu.entity;

public class QueryVo {
    private String cookname = null;
    private String name= null;
    private Integer tid= 0;
    private Double start= 0.0;
    private Double end= 0.0;

    public QueryVo() {
    }

    public QueryVo(String cookname, String name, Integer tid, Double start, Double end) {
        this.cookname = cookname;
        this.name = name;
        this.tid = tid;
        this.start = start;
        this.end = end;
    }

    public String getCookname() {
        return cookname;
    }

    public void setCookname(String cookname) {
        this.cookname = cookname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }
}
