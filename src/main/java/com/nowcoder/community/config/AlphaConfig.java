package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author zyy
 * @create 2022-05-27 22:07
 */
@Configuration //表示这不是一个普通的类，这是一个配置类
public class AlphaConfig {
    @Bean //要定义第三方的bean需要加bean的注解
    public SimpleDateFormat simpleDateFormat()//方法名就是bean的名字
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //这个方法返回的对象将被装配到容器里

    }

}
