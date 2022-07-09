package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface RoomDao extends BaseMapper<Room> {
    @Select("select * from room where Room_name like #{RoomName}")
    List<Room> getByName(@Param("RoomName") String RoomName);

    @Select("select * from room limit #{pageNum},#{pageSize}")
    List<Room> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select * from room where room_Type=1 and status = 2")
    List<Room> getBigroom();

    @Select("select * from room where room_Type=2 and status = 2")
    List<Room> getMediumroom();

    @Select("select * from room where status = 2")
    List<Room> getAllRoom();

    @Select("select * from room where room_Type=3 and status = 2")
    List<Room> getSmallroom();


    @Select("select count(*) from room")
    int selectCount();


    @Select("select * from room where room_name like #{roomName} limit #{pageNum},#{pageSize}")
    List<Room> search(@Param("roomName") String roomName, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from room where room_name like #{roomName}")
    int findCount(@Param("roomName") String roomName);

    @Select("select * from room where manager_id =#{id}")
    Room getcoRoomName(@Param("id") int id);


}
