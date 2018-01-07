package com.njust.blog.service;

import com.njust.blog.dao.BlogMapper;
import com.njust.blog.model.BlogEntity;
import com.njust.blog.model.UserEntity;
import com.njust.blog.model.vo.BlogVO;
import com.njust.blog.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/3 16:53
 * @modified by
 */
@Service("blogService")
public class BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Resource
    private UserService userService;

    public int addBlog(String title, String content, Integer userID, Date pubDate) {
        BlogEntity blog = new BlogEntity();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserID(userID);
        blog.setPubDate(pubDate);
        Integer id = blogMapper.insert(blog);
        return id;
    }

    public int addBlog(BlogEntity blog) {
        Integer id = blogMapper.insert(blog);
        return id;
    }

    public int deleteByID(Integer id) {
        blogMapper.deleteByID(id);
        return id;
    }

    public List<BlogEntity> findAll() {
        List<BlogEntity> list = blogMapper.selectAll();
        return list;
    }

    public List<BlogVO> findAllVO(){
        List<BlogEntity> doList = blogMapper.selectAll();
        List<BlogVO> voList = new ArrayList<BlogVO>();
        for(BlogEntity blog : doList){
            BlogVO vo = new BlogVO();
            UserEntity user = userService.findByID(blog.getUserID());
//            BeanUtils.copyProperties(vo, blog);
            BeanUtils.copyProperties(vo, blog);
            vo.setUser(user);
            voList.add(vo);
        }
        return voList;
    }

    public BlogEntity findByID(Integer id) {
        BlogEntity blog = blogMapper.selectByID(id);
        return blog;
    }

    public int update(BlogEntity blog){
        blogMapper.update(blog);
        return blog.getId();
    }
}
