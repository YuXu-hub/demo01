package com.yx.menu.controller;


import com.yx.menu.entity.Type;
import com.yx.menu.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gs
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/type")
@CrossOrigin
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping
    public List<Type> findType(){
        return typeService.list();
    }
}
