package com.njust.blog.utils;

import com.njust.blog.model.BlogEntity;
import com.njust.blog.model.vo.BlogVO;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/6 16:39
 * @modified by
 */
public class BeanUtils {
    /**
     * 属性复制
     * @param blogVO
     * @param blogDO
     */
    public static void copyProperties(BlogVO blogVO, BlogEntity blogDO){
        blogVO.setId(blogDO.getId());
        blogVO.setTitle(blogDO.getTitle());
        blogVO.setContent(blogDO.getContent());
        blogVO.setPubDate(blogDO.getPubDate());
        blogVO.setUserID(blogDO.getUserID());
    }
}
