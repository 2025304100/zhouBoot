package com.zhou.zhouboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName(value="demo_user")
public class DemoUser extends BaseModel {
    private String userName;

    private String pwd;


}