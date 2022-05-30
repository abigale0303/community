package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author zyy
 * @create 2022-05-27 20:26
 */
@Repository
@Primary //优先装配
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select()
    {
        return "MyBatis";
    }


}
