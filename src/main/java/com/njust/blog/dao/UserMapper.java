package com.njust.blog.dao;

import com.njust.blog.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/3 13:56
 * @modified by
 */
@Component
public interface UserMapper {
    /**
     * 刪除
     *
     * @param id
     * @return
     */
    int deleteByID(Integer id);

    /**
     * 插入
     *
     * @param user
     * @return
     */
    int insert(UserEntity user);

    /**
     * 查询所有
     * @return
     */
    List<UserEntity> selectAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    UserEntity selectByID(Integer id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int update(UserEntity user);
}
