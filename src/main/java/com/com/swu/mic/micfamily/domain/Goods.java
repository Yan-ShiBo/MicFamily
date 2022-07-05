package com.com.swu.mic.micfamily.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/5 星期二 11:47
 * @ package name： com.com.swu.mic.micfamily.domain
 * @ Project name： MicFamily
 * @ Description：
 */
@TableName("goods")
@Data
public class Goods {
    @TableId("id")
    private Integer id;
    private String goodsName;
    private double price;
    private Integer creditExchange;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCreditExchange() {
        return creditExchange;
    }

    public void setCreditExchange(Integer creditExchange) {
        this.creditExchange = creditExchange;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
