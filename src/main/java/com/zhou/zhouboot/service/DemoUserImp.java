package com.zhou.zhouboot.service;

import com.zhou.zhouboot.entity.DemoUser;
import com.zhou.zhouboot.mapper.DemoUserMapper;
import com.zhou.zhouboot.utils.MyVoToModel;
import com.zhou.zhouboot.vo.DemoUserVo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhougq
 **/
@Service
public class DemoUserImp implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Transactional(rollbackFor = Exception.class)
    public String addUser(DemoUserVo demoUserVo) {
        DemoUserMapper demoUserMapper = (DemoUserMapper) applicationContext.getBean("demoUserMapper");
        DemoUser demoUser = new DemoUser();
        MyVoToModel<DemoUser,DemoUserVo> model = new MyVoToModel<>();
        model.voToModel(demoUserVo,demoUser);

        System.out.println(demoUser.getUserName());
        demoUserMapper.addUser(demoUser);
        return "success";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext= applicationContext;
    }
}
