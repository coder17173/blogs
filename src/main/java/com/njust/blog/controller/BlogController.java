package com.njust.blog.controller;

import com.njust.blog.model.BlogEntity;
import com.njust.blog.model.UserEntity;
import com.njust.blog.model.vo.BlogVO;
import com.njust.blog.service.BlogService;
import com.njust.blog.service.UserService;
import com.njust.blog.utils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/5 14:40
 * @modified by
 */
@Controller
public class BlogController {
    @Resource
    BlogService blogService;
    @Resource
    UserService userService;

    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap){
        List<BlogVO> blogs = blogService.findAllVO();
        modelMap.addAttribute("blogList", blogs);
        return "admin/blogs";
    }

    @RequestMapping(value = "admin/blogs/add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        List<UserEntity> userList = userService.findAll();
        modelMap.addAttribute("userList", userList);
        return "/admin/addBlog";
    }

    @RequestMapping(value = "/admin/blogs/addP", method = RequestMethod.POST)
    public String addP(@ModelAttribute("blog") BlogEntity blog){
        System.out.println(blog.getTitle());
/*      System.out.println(blog.getUser().getNickName());
        BlogEntity blogDO = new BlogEntity();
        BeanUtils.copyProperties(blogDO, blog);*/
        blogService.addBlog(blog);
        return "redirect:/admin/blogs";
    }


    @RequestMapping(value = "admin/blogs/show/{id}", method = RequestMethod.GET)
    public String showBlog(@ModelAttribute("id") Integer id, ModelMap modelMap){
        BlogEntity blogDO = blogService.findByID(id);
        BlogVO blogVO = new BlogVO();
        UserEntity user = userService.findByID(blogDO.getUserID());
        blogVO.setUser(user);
        BeanUtils.copyProperties(blogVO, blogDO);
        modelMap.addAttribute("blog", blogVO);
        return "/admin/blogDetail";
    }

    @RequestMapping(value = "admin/blogs/update/{id}", method = RequestMethod.GET)
    public String updateBlog(@ModelAttribute("id") Integer id, ModelMap modelMap){
        BlogEntity blogDO = blogService.findByID(id);
        BlogVO blogVO = new BlogVO();
        List<UserEntity> userList = userService.findAll();
        UserEntity user = userService.findByID(blogDO.getUserID());
        blogVO.setUser(user);
        BeanUtils.copyProperties(blogVO,blogDO);
        modelMap.addAttribute("blog", blogVO);
        modelMap.addAttribute("userList", userList);
        return "admin/updateBlog";
    }

    @RequestMapping(value = "admin/blogs/updateP", method = RequestMethod.POST)
    public String updateBlog(@ModelAttribute("blogP") BlogEntity blog){
        blogService.update(blog);
        return "redirect:/admin/blogs";
    }

    @RequestMapping(value = "admin/blogs/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog(@ModelAttribute("id") Integer id){
        blogService.deleteByID(id);
        return "redirect:/admin/blogs";
    }
}
