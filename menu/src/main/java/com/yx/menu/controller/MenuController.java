package com.yx.menu.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.entity.User;
import com.yx.menu.entity.Menu;
import com.yx.menu.entity.MenuVo;
import com.yx.menu.entity.Msg;
import com.yx.menu.entity.QueryVo;
import com.yx.menu.feignService.FeignService;
import com.yx.menu.service.IMenuService;
import com.yx.menu.util.FileUploadUtil;
import com.yx.menu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private FeignService feignService;

    @PostMapping("/findAll")
    public PageInfo<MenuVo> findAll(@RequestParam(value = "cpage",defaultValue = "1") Integer cpage,
                                    @RequestBody QueryVo queryVo){
        return menuService.findAll(cpage,queryVo);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file){
        String s = FileUploadUtil.uploadFile(file, "D:\\nginx\\nginx-1.12.2\\html\\img");
        System.out.println(s);
        return "http://localhost:8090/img/"+s;
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody Menu menu){
        return menuService.add(menu);
    }

    @PostMapping("/pass")
    public Boolean pass(@RequestBody MenuVo menuVo){
        return menuService.pass(menuVo);
    }

    @GetMapping("/msgfindAll")
    public List<Msg> findAll(){
        return menuService.findMsg();
    }


    @PostMapping("/noPass")
    public Boolean noPass(@RequestBody MenuVo menuVo){

        return menuService.pass(menuVo);
    }

    @GetMapping("/mongoMH")
    public PageUtil<Msg> findAll(@RequestParam(value = "sendname",defaultValue = "",required = false) String sendname,
                                 @RequestParam(value = "id",defaultValue = "0") String id,
                                 @RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "2") int size){

        return menuService.findMongMh(id, sendname,page,size) ;
    }

    @GetMapping("/findFeign")
    public List<User> findFeign(){
        return feignService.findCook();
    }
}
