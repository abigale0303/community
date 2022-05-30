package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.ws.ServiceMode;

/**
 * @author zyy
 * @create 2022-05-27 20:46
 */
@Service //业务组件的注解
@Scope("prototype")//每次访问一遍都会生成新的实例
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;
    public String find()
    {
        return alphaDao.select();
    }

    public AlphaService()
    {
        System.out.println("实例化AlphaService");
    }
    @PostConstruct //方法会在构造器之后调用
    public void init()
    {
        System.out.println("初始化AlphaService");
    }
    @PreDestroy//在销毁对象之前调用方法
    public void destroy()
    {
        System.out.println("销毁AlphaService");
    }
}
