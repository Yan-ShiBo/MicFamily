package com.com.swu.mic.micfamily.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.VIP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/6/28 星期二 14:21
 * @ package name： com.com.swu.mic.micfamily.dao
 * @ Project name： MicFamily
 * @ Description：
 */
@Component
@Mapper
public interface VIPDao extends BaseMapper<VIP> {
    @Select("select * from vip where user_name like #{userName}")
    List<VIP> getByName(@Param("userName") String userName);

    @Select("select * from vip limit #{pageNum},#{pageSize}")
    List<VIP> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from vip")
    int selectCount();

    @Select("select *from vip where user_name like #{userName} limit #{pageNum},#{pageSize}")
    List<VIP> search(@Param("userName") String userName, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from vip where user_name like #{userName}")
    int findCount(@Param("userName") String userName);

}

