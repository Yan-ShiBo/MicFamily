package com.com.swu.mic.micfamily.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.com.swu.mic.micfamily.dao.OrderDao;
import com.com.swu.mic.micfamily.domain.Order;
import com.com.swu.mic.micfamily.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
}
