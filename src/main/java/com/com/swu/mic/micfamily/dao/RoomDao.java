package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface RoomDao extends BaseMapper<Room> {
    @Select("select * from room where Room_name like #{RoomName}")
    List<Room> getByName(@Param("RoomName") String RoomName);

    @Select("select * from room limit #{pageNum},#{pageSize}")
    List<Room> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);


    @Select("select * from room where status = 2  limit #{pageNum},#{pageSize}")
    List<Room> search1(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from room where status = 2")
    int findCount1();


    @Select("select * from room where status = 2")
    List<Room> getAllRoom();


    @Select("select * from room where room_Type=1 and status = 2 limit #{bigNum},#{bigSize}")
    List<Room> getBigroom(@Param("bigNum") Integer bigNum, @Param("bigSize") Integer bigSize);

    @Select("select count(*) from room where room_Type=1 and status = 2")
    int CountBig();


    @Select("select * from room where room_Type=2 and status = 2 limit #{mediumNum},#{mediumSize}")
    List<Room> getMediumroom(@Param("mediumNum") Integer mediumNum, @Param("mediumSize") Integer mediumSize);

    @Select("select count(*) from room where room_Type=2 and status = 2")
    int CountMedium();


    @Select("select * from room where room_Type=3 and status = 2 limit #{smallNum},#{smallSize}")
    List<Room> getSmallroom(@Param("smallNum") Integer smallNum, @Param("smallSize") Integer smallSize);

    @Select("select count(*) from room where room_Type=3 and status = 2")
    int CountSmall();


    @Select("select count(*) from room")
    int selectCount();


    @Select("select * from room where room_name like #{roomName} limit #{pageNum},#{pageSize}")
    List<Room> search(@Param("roomName") String roomName, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from room where room_name like #{roomName}")
    int findCount(@Param("roomName") String roomName);

    @Select("select * from room where manager_id =#{manager_id}")
    Room getcoRoomName(@Param("manager_id") int manager_id);


    @Update("update room set manager_id = null, status = '2' where manager_id =#{manager_id} ")
    public int updateID(@Param("manager_id") int manager_id);


}
