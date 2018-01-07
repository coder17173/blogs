package com.njust.blog.service;

import com.njust.blog.dao.UserMapper;
import com.njust.blog.model.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/3 16:44
 * @modified by
 */
@Service("userService")
public class UserService {
    @Resource
    private UserMapper userMapper;

    public int addUser(String nickName, String password, String firstName, String lastName) {
        UserEntity user = new UserEntity();
        user.setNickName(nickName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Integer id = userMapper.insert(user);
        return id;
    }

    public int addUser(UserEntity userEntity) {
        Integer id = userMapper.insert(userEntity);
        return id;
    }

    public int deleteByID(Integer id) {
        userMapper.deleteByID(id);
        return id;
    }

    public List<UserEntity> findAll() {
        List<UserEntity> list = userMapper.selectAll();
        return list;
    }

    public UserEntity findByID(Integer id) {
        UserEntity user = userMapper.selectByID(id);
        return user;
    }

    public int updateUser(UserEntity userEntity){
        userMapper.update(userEntity);
        return userEntity.getId();
    }
}
