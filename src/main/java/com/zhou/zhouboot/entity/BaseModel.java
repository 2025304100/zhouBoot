package com.zhou.zhouboot.entity;

import java.util.UUID;

/**
 * @author zhougq
 **/
public class BaseModel {
    private Integer id;

     BaseModel() {
        this.id= UUID.randomUUID().hashCode();
     }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
