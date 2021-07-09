package com.yx.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


public class MenuVo {
    private Integer id;
    private String name;
    private Double price;
    private Double cost;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uptime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date downtime;
    private Integer cook;
    private String cookname;
    private Integer waiter;
    private String waitername;
    private Integer audit;
    private String auditname;
    private String imgs;


    @TableField(exist = false)
    private List<String> imglist;
    private Integer state;
   private String tname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Date getDowntime() {
        return downtime;
    }

    public void setDowntime(Date downtime) {
        this.downtime = downtime;
    }

    public Integer getCook() {
        return cook;
    }

    public void setCook(Integer cook) {
        this.cook = cook;
    }

    public String getCookname() {
        return cookname;
    }

    public void setCookname(String cookname) {
        this.cookname = cookname;
    }

    public Integer getWaiter() {
        return waiter;
    }

    public void setWaiter(Integer waiter) {
        this.waiter = waiter;
    }

    public String getWaitername() {
        return waitername;
    }

    public void setWaitername(String waitername) {
        this.waitername = waitername;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public String getAuditname() {
        return auditname;
    }

    public void setAuditname(String auditname) {
        this.auditname = auditname;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public List<String> getImglist() {
        return imglist;
    }

    public void setImglist(List<String> imglist) {
        this.imglist = imglist;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public MenuVo() {
    }

    public MenuVo(Integer id, String name, Double price, Double cost, Date uptime, Date downtime, Integer cook, String cookname, Integer waiter, String waitername, Integer audit, String auditname, String imgs, List<String> imglist, Integer state, String tname) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.uptime = uptime;
        this.downtime = downtime;
        this.cook = cook;
        this.cookname = cookname;
        this.waiter = waiter;
        this.waitername = waitername;
        this.audit = audit;
        this.auditname = auditname;
        this.imgs = imgs;
        this.imglist = imglist;
        this.state = state;
        this.tname = tname;
    }
}
