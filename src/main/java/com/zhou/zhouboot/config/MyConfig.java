package com.zhou.zhouboot.config;

import com.zhou.zhouboot.utils.MyVoToModel;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author zhougq
 **/
@Configurable
public class MyConfig {
    @Bean
    public MyVoToModel myVoToModel(){
        return new MyVoToModel();
    }

}
