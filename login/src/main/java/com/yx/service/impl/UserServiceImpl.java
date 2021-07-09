package com.yx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.entity.Result;
import com.yx.entity.User;
import com.yx.mapper.UserMapper;
import com.yx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<User> findCook() {
        Object c = redisTemplate.opsForValue().get("c");
        if (c != null){
            return (List<User>) c;
        }else {
            List<User> cook = userMapper.findCook();
            redisTemplate.opsForValue().set("c", cook);
            return cook;
        }
    }

    @Override
    public List<User> findWaiter() {
        Object w = redisTemplate.opsForValue().get("w");
        if (w != null){
            return (List<User>) w;
        }else {
            List<User> waiter = userMapper.findWaiter();
            redisTemplate.opsForValue().set("w", waiter);
            return waiter;
        }
    }

    @Override
    public List<User> findAudit() {
        Object a = redisTemplate.opsForValue().get("a");
        if (a != null){
            return (List<User>) a;
        }else {
            List<User> audit = userMapper.findAudit();
            redisTemplate.opsForValue().set("a", audit);
            return audit;
        }
    }

    @Override
    public Result login(User user) {
        User loginuser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (loginuser!=null && loginuser.getPwd().equals(user.getPwd())){
            return new Result(true,"登录成功",loginuser);
        }
        return new Result(false,"登录失败");
    }
}
