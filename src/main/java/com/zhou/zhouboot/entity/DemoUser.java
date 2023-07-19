package com.zhou.zhouboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="demo_user")
public class DemoUser {
    @TableId(type =IdType.ASSIGN_ID)
    private Integer id;

    private String userName;

    private String pwd;


}