package com.com.swu.mic.micfamily.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.com.swu.mic.micfamily.dao.RoomDao;
import com.com.swu.mic.micfamily.domain.Room;
import com.com.swu.mic.micfamily.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomImpl extends ServiceImpl<RoomDao, Room> implements RoomService {
}
