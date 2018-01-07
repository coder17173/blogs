package com.njust.blog.controller;

import com.njust.blog.model.UserEntity;
import com.njust.blog.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/3 11:49
 * @modified by
 */

@Controller
public class UserController {
    @Resource
    public UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        //查询用户表中的所有用户
        List<UserEntity> userList = userService.findAll();
        if (userList.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (UserEntity user : userList) {
                System.out.println(user.toString());
            }
        }
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("userList", userList);
        // 返回pages目录下的admin/users.jsp页面
        return "admin/users";
    }

    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        return "admin/addUser";
    }

    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {
        userService.addUser(userEntity);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@ModelAttribute("id") Integer id, ModelMap modelMap){
        UserEntity userEntity = userService.findByID(id);
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }

    @RequestMapping(value = "/admin/users/update/{id}", method =RequestMethod.GET)
    public String updateUser(@ModelAttribute("id") Integer id, ModelMap modelMap){
        UserEntity userEntity = userService.findByID(id);
        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String update(@ModelAttribute("userP") UserEntity userEntity){
        userService.updateUser(userEntity);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String delete(@ModelAttribute("id") Integer id){
        userService.deleteByID(id);
        return "redirect:/admin/users";
    }
}
