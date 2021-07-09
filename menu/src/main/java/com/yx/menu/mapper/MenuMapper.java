package com.yx.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.menu.entity.Menu;
import com.yx.menu.entity.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuVo> findAll(@Param("cookname") String cookname,@Param("waitername") String waitername,@Param("auditname") String auditname,@Param("name") String name,@Param("tid") Integer tid,@Param("end") Double end,@Param("start") Double start);
}
