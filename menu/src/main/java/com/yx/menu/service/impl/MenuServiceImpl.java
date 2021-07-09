package com.yx.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.menu.dao.EsDao;
import com.yx.menu.dao.MongoDao;
import com.yx.menu.entity.*;
import com.yx.menu.mapper.ImgMapper;
import com.yx.menu.mapper.MenuMapper;
import com.yx.menu.service.IMenuService;
import com.yx.menu.util.PageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ImgMapper imgMapper;

    @Autowired
    private EsDao esDao;

    @Autowired
    private MongoDao mongoDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public PageInfo<MenuVo> findAll(Integer cpage, QueryVo queryVo) {
        PageHelper.startPage(cpage,3);
        List<MenuVo> list = menuMapper.findAll(queryVo.getCookname(), queryVo.getCookname(), queryVo.getCookname(), queryVo.getName(), queryVo.getTid(), queryVo.getEnd(), queryVo.getStart());
        ArrayList<String> strings = new ArrayList<>();
        MenuEs menuEs = new MenuEs();
        for (MenuVo menuVo : list) {
            BeanUtils.copyProperties(menuVo,menuEs);
            esDao.save(menuEs);
            String[] split = menuVo.getImgs().split(",");
            for (String s : split) {
                strings.add(s);
            }
            menuVo.setImglist(strings);
            strings = null;
            strings =  new ArrayList<String>();
        }
        return new PageInfo<>(list);
    }

    @Override
    public Boolean add(Menu menu) {
        menu.setState(0);
        menuMapper.insert(menu);
        for (String s : menu.getImglist()) {
            Img img = new Img(0, menu.getId(), s);
            imgMapper.insert(img);
        }
        return true;
    }

    @Override
    public Boolean pass(MenuVo menuVo) {
        rabbitTemplate.convertAndSend("01a",menuVo.getAuditname());
        Menu menu = menuMapper.selectById(menuVo.getId());
        menu.setState(1);
        menuMapper.insert(menu);
        return true;
    }



    @Override
    public List<Msg> findMsg() {
        return mongoDao.findAll();
    }

    @Override
    public PageUtil<Msg> findMongMh(String id, String sendname, int page,int size) {
        Query query = new Query();
        if (!id.equals("0")){
           query.addCriteria(Criteria.where("id").is(id));
        }
        if (!sendname.equals("")){
                query.addCriteria(Criteria.where("sendName").regex(".*"+sendname+".*"));
        }
        List<Msg> msgs = mongoTemplate.find(query, Msg.class);
        long count = mongoTemplate.count(query, Msg.class);
        return new PageUtil<Msg>(page,count,msgs,size);
    }
}
