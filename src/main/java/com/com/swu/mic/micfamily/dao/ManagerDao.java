package com.com.swu.mic.micfamily.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Manager;
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
public interface ManagerDao extends BaseMapper<Manager> {
    @Select("select * from manager where user_name like #{userName}")
    List<Manager> getByName(@Param("userName") String userName);

    @Select("select * from manager limit #{pageNum},#{pageSize}")
    List<Manager> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from manager")
    int selectCount();

}

