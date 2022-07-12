package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Msgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MsgsDao extends BaseMapper<Msgs> {
    @Select("select * from msgs where type=#{type}")
    public List<Msgs> selectType(@Param("type") Integer type);

    @Update("update msgs set type=0   where msgs_id=#{msgid}")
    public Integer updatamsg(@Param("msgid") Integer msgid);

    @Select("select count(*) from msgs where type = 1")
    public Integer checkType();
}
