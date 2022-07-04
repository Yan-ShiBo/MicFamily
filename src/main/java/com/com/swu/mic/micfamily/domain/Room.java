package com.com.swu.mic.micfamily.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("room")
@Data
public class Room {

    @TableId("id")
    private Integer id;
    private String roomName;

    private String status;
    private String roomType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return roomType;
    }

    public void setType(String roomType) {
        this.roomType = roomType;
    }
}
