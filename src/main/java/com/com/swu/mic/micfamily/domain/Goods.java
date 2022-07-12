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

    private String goodsName;
    private Double price;
    private Double creditExchange;
    private Integer quantity;
    private Integer OrderId;

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCreditExchange() {
        return creditExchange;
    }

    public void setCreditExchange(Double creditExchange) {
        this.creditExchange = creditExchange;
    }

}
