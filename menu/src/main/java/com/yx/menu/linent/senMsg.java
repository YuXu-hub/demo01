package com.yx.menu.linent;

import com.yx.menu.dao.MongoDao;
import com.yx.menu.entity.MenuVo;
import com.yx.menu.entity.Msg;
import com.yx.menu.util.IdWorker;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "01a")
public class senMsg {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoDao mongoDao;

    @RabbitHandler
    public void msg(String  Auditname){
        Msg msg = new Msg();
        msg.setId(idWorker.nextId()+"");
        msg.setContent("你的菜品审核了");
        msg.setSendName(Auditname);
        msg.setState("已发送");
        msg.setTitle("审核通知");
        mongoDao.save(msg);
    }
}
