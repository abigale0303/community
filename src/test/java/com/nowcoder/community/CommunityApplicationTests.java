package com.nowcoder.community;

import com.nowcoder.community.config.AlphaConfig;
import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;


import java.text.SimpleDateFormat;
import java.util.Date;
//@RunWith
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;//记录Spring容器applicationContext

    }
    @Test
     public void testApplicationContext()
    {
        System.out.println(applicationContext);
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());
        alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
        System.out.println(alphaDao.select());
    }
    @Test
    public void testBeanManagement()
    {
        //通过容器获取service
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

    }
    @Test
    public void testBeanConfig()
    {
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }
    //依赖注入的方式
    @Autowired //注入的注解
    @Qualifier("alphaHibernate") //希望注入的还是不是那个优先级高的那个bean
    private AlphaDao alphaDao;//Spring容器能够把Alphadao注入给这个属性，然后就可以直接使用这个属性了

    @Autowired
    private AlphaService alphaService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Test
    public void testDI()//测试注入
    {
        System.out.println(alphaDao);//测试成员变量能不能取到这个AlphaDao
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);

    }


//	@Test
//	void contextLoads() {
//	}

}
