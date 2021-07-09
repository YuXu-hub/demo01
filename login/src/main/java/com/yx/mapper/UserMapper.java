package com.yx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where roles = 1")
    List<User> findCook();
    @Select("select * from user where roles = 2")
    List<User> findWaiter();
    @Select("select * from user where roles = 3")
    List<User> findAudit();
}
