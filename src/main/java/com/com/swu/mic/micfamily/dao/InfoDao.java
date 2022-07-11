package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/4 星期一 11:42
 * @ package name： com.com.swu.mic.micfamily.dao
 * @ Project name： MicFamily
 * @ Description：
 */
@Component
@Mapper
public interface InfoDao extends BaseMapper<Info> {
    @Select("select * from info where n_id = #{id}")
    Info getInfoById(@Param("id") Integer id);

    @Insert("update info set info = #{info} where id = #{id}")
    Boolean upinfo(@Param("id") Integer id, @Param("info") String inf);


}
