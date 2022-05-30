package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


/**
 * @author zyy
 * @create 2022-05-28 21:19
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;//把UserMapper注入进来  虽然有红色下划线但是运行不出错

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser()
    {
        //查
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder102@sina.com");
        System.out.println(user);

    }

    @Test
    public void testInsertUser()
    {
        User user = new User();
        user.setUsername("zyy");
        user.setPassword("123456");
        user.setSalt("abs");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/001.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }

    @Test
    public void testUpdateUser()
    {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/101.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "654321");
        System.out.println(rows);
    }
    @Test
    public void testSelectPosts()
    {
        List<DiscussPost> list =  discussPostMapper.selectDiscussPosts(0, 0,10);
        for(DiscussPost dis:list)
        {
            System.out.println(dis);
        }
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }



































}
