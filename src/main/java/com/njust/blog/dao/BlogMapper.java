package com.njust.blog.dao;

import com.njust.blog.model.BlogEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/3 14:04
 * @modified by
 */
@Component
public interface BlogMapper {
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
     * @param blog
     * @return
     */
    int insert(BlogEntity blog);

    /**
     * 查询所有
     * @return
     */
    List<BlogEntity> selectAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    BlogEntity selectByID(Integer id);

    /**
     * 更新博文
     * @param blog
     * @return
     */
    int update(BlogEntity blog);
}
