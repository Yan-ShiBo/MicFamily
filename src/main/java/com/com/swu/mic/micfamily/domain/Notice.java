package com.com.swu.mic.micfamily.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/4 星期一 11:38
 * @ package name： com.com.swu.mic.micfamily.domain
 * @ Project name： MicFamily
 * @ Description：
 */
@TableName("notice")
@Data
public class Notice {

    @TableId("id")
    private Integer id;
    private Integer power;
    private Integer category;
    private Date date;
    private String topic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "date='" + date + '\'' +
                '}';
    }

}
