package com.com.swu.mic.micfamily.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("info")
@Data
public class Info {
    @TableId
    private Integer id;
    private String info;
    private Integer nid;
}
