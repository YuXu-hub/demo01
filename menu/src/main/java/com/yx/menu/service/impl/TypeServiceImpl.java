package com.yx.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.menu.entity.Type;
import com.yx.menu.mapper.TypeMapper;
import com.yx.menu.service.ITypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

}
