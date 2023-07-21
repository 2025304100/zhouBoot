package com.zhou.zhouboot.controller;

import com.zhou.zhouboot.vo.DemoUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougq
 **/
@RestController
@RequestMapping("/demo")
public class DemoUser {
    @Autowired
    private ApplicationContext applicationContext;
  @PostMapping(value = "/addUser")
  public String addUser(@RequestBody DemoUserVo demoUserVo){
        applicationContext.getBean("demoUserImp",com.zhou.zhouboot.service.DemoUserImp.class).addUser(demoUserVo);
      return "success";
  }
}
