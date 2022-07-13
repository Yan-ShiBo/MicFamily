package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/4 星期一 11:42
 * @ package name： com.com.swu.mic.micfamily.dao
 * @ Project name： MicFamily
 * @ Description：
 */

@Component
@Mapper
public interface NoticeDao extends BaseMapper<Notice> {
    @Insert("insert into notice (power,category,date) values( #{power},#{category},#{date})")
    Boolean add(Notice notice);

    @Select("select * from notice where topic like #{topic}")
    List<Notice> noticefind(@Param("topic") String topic);

    @Select("select * from notice where power = 5")
    List<Notice> getAll();
}
