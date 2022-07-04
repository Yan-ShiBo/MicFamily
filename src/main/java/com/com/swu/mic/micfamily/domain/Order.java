package com.com.swu.mic.micfamily.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_order")
@Data
public class Order {

    @TableId("id")
    private Integer id;
    private String orderInfo;
    private String orderTime;
    private String coRoom;
    private Integer consumAmout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCoRoom() {
        return coRoom;
    }

    public void setCoRoom(String coRoom) {
        this.coRoom = coRoom;
    }

    public Integer getConsumAmout() {
        return consumAmout;
    }

    public void setConsumAmout(Integer consumAmout) {
        this.consumAmout = consumAmout;
    }
}
