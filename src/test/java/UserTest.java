import com.njust.blog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @author zhanghang
 * @description
 * @date 2018/1/3 17:00
 * @modified by
 */
public class UserTest {
    @Resource
    private UserService userService;

    @Before
    public void before() {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"
                , "classpath:applicationContext-mybatis.xml"});
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void addUser() {
        userService.addUser("绛莜筱寒", "123123", "张", "航");
    }
}
