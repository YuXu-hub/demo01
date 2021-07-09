package com.yx.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.menu.entity.Menu;
import com.yx.menu.entity.MenuVo;
import com.yx.menu.entity.Msg;
import com.yx.menu.entity.QueryVo;
import com.yx.menu.util.PageUtil;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
public interface IMenuService extends IService<Menu> {

    PageInfo<MenuVo> findAll(Integer cpage, QueryVo queryVo);

    Boolean add(Menu menu);

    Boolean pass(MenuVo menuVo);

    List<Msg> findMsg();

    PageUtil<Msg> findMongMh(String id, String sendname, int page,int size);
}
