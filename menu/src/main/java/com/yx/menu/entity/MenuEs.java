package com.yx.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
@Data
@Document(indexName = "1901a",type = "menu")
public class MenuEs {
    @Field
    private Integer id;
    @Field
    private String name;
    @Field
    private Double price;
    private Double cost;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uptime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date downtime;
    private Integer cook;
    @Field
    private String cookname;
    private Integer waiter;
    private String waitername;
    private Integer audit;
    @Field
    private String auditname;
    private String imgs;

    private Integer state;
    private String tname;
    @TableField(exist = false)
    private List<String> imglist;


}
