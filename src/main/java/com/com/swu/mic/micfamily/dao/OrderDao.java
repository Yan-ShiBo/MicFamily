package com.com.swu.mic.micfamily.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.swu.mic.micfamily.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
}
