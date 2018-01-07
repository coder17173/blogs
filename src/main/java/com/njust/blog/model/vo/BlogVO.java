package com.njust.blog.model.vo;

import com.njust.blog.model.BlogEntity;
import com.njust.blog.model.UserEntity;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/5 15:07
 * @modified by
 */
public class BlogVO extends BlogEntity {
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
