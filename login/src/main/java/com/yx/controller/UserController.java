package com.yx.controller;


import com.yx.entity.Result;
import com.yx.entity.User;
import com.yx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/findCook")
    public List<User> findCook(){
        return userService.findCook();
    }

    @GetMapping("/findWaiter")
    public List<User> findWaiter(){
        return userService.findWaiter();
    }

    @GetMapping("/findAudit")
    public List<User> findAudit(){
        return userService.findAudit();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

}
