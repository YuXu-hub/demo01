package com.yx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.entity.Result;
import com.yx.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
public interface IUserService extends IService<User> {

    List<User> findCook();

    List<User> findWaiter();

    List<User> findAudit();

    Result login(User user);
}
