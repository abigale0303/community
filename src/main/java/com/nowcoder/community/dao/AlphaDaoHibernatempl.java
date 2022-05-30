package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zyy
 * @create 2022-05-27 17:39
 */
@Repository("alphaHibernate")//访问数据库的Bean采用这个注解 括号里的是这个bean的名字
public class AlphaDaoHibernatempl implements AlphaDao{
    @Override
    public String select()
    {
        return "Hibernate";
    }
}
