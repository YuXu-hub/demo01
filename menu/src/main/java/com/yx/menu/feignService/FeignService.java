package com.yx.menu.feignService;


import com.yx.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("login")
public interface FeignService {

    @GetMapping("/user/findCook")
     List<User> findCook();
}
