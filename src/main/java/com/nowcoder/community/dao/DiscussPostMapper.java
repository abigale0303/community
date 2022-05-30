package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zyy
 * @create 2022-05-29 9:20
 */
@Mapper   //打开注解以后才能被容器扫描，接口才能自动实现自动装配
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    int selectDiscussPostRows(@Param("userId") int userId);   //@Param("userId")用于给参数起别名//如果只有一个参数，并且在<if>里使用，必须加别名


}
