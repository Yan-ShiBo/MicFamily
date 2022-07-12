package com.com.swu.mic.micfamily.domain;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/12 星期二 9:48
 * @ package name： com.com.swu.mic.micfamily.domain
 * @ Project name： MicFamily
 * @ Description：
 */
public class buyGoods {
    Order order;
    private boolean flag;
    private String msg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
