package com.zhou.zhouboot.controller;

import com.zhou.zhouboot.annotation.RepealSubmit;
import com.zhou.zhouboot.exception.NoAuthorizedException;
import com.zhou.zhouboot.service.DemoUserImp;
import com.zhou.zhouboot.vo.DemoUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhougq
 **/
@RestController
@RequestMapping("/demo")
public class DemoUser {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DemoUserImp demoUserImp;

    @PostMapping(value = "/addUser")
    @RepealSubmit
    public String addUser(@RequestBody DemoUserVo demoUserVo) {
        demoUserImp.addUser(demoUserVo);
        return "success";
    }

    @GetMapping(value = "/login")
    public String login() throws NoAuthorizedException {

        System.out.println("login------------------------------>");
        throw new NoAuthorizedException("112");
//        return "login";
    }
}
