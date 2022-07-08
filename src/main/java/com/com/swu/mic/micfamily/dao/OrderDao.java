package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderDao extends BaseMapper<Order> {
    @Select("select * from t_order where co_room like #{coRoom}")
    List<Order> getByName(@Param("coRoom") String coRoom);

    @Select("select * from t_order limit #{pageNum},#{pageSize}")
    List<Order> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from t_order")
    int selectCount();


    @Select("select * from t_order where co_room like #{roomId}")
    Order getOrderById(@Param("roomId") String roomId);


    @Select("select * from t_order where co_room like #{coRoom} limit #{pageNum},#{pageSize}")
    List<Order> search(@Param("coRoom") String coRoom, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from t_order where co_room like #{coRoom}")
    int findCount(@Param("coRoom") String coRoom);


    @Select("select * from t_order where co_room = #{room_name}")
    Order getcoOrder(@Param("room_name") String room_name);

}