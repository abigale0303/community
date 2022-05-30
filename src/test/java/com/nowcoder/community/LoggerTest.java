package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;//注意选择的logger是org.slf4j
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author zyy
 * @create 2022-05-30 10:09
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);//实例化记录日志的组件，就是logger接口
    //每一个类记录日志都单独为这个类实例化一个logger，不同的类用不同的logger
    @Test
    public void testLogger()
    {
        System.out.println(logger.getName());
        //开始用logger记日志
        logger.debug("debug log");//一般用的最低的级别就是debug，trace几乎不用

        logger.info("info log");

        logger.warn("warn log");

        logger.error("error log");


    }
}
