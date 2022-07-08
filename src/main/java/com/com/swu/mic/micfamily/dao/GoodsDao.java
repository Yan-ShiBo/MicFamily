package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/5 星期二 11:48
 * @ package name： com.com.swu.mic.micfamily.dao
 * @ Project name： MicFamily
 * @ Description：
 */
@Component
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
    @Select("select * from goods where goods_name like #{goodsName}")
    List<Goods> getByName(@Param("goodsName") String goodsName);

    @Select("select * from goods limit #{pageNum},#{pageSize}")
    List<Goods> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from goods")
    int selectCount();

    @Select("select * from goods where goods_name like #{goodsName} limit #{pageNum},#{pageSize}")
    List<Goods> search(@Param("goodsName") String goodsName, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from goods where goods_name like #{goodsName}")
    int findCount(@Param("goodsName") String goodsName);

    @Select("select * from goods where order_id = #{OrderId}")
    List<Goods> getByOrderId(@Param("OrderId") Integer OrderId);
}