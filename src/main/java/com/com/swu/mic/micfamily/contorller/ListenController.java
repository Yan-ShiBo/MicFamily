package com.com.swu.mic.micfamily.contorller;


import com.com.swu.mic.micfamily.dao.MsgsDao;
import com.com.swu.mic.micfamily.dao.RoomDao;
import com.com.swu.mic.micfamily.domain.Manager;
import com.com.swu.mic.micfamily.domain.Msgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class ListenController {
    @Autowired
    public MsgsDao msgsDao;
    @Autowired
    public RoomDao roomDao;

    public boolean saveMsg(Manager manager) {
        Msgs msgs = new Msgs();
        msgs.setMsgsCont("有新的包间预定");
        msgs.setType(1);
        msgs.setReserverName(manager.getUserName());
        String roomName = roomDao.getcoRoomName(manager.getId()).getRoomName();
        msgs.setReserveRoom(roomName);
        return msgsDao.insert(msgs) > 0;
    }


    @PutMapping("/putmsg")
    public boolean updatamsg(@RequestParam("msgid") Integer msgid) {

        return msgsDao.updatamsg(msgid) > 0;
    }

    @GetMapping("/msg")
    public List<Msgs> getMsgs() {

        return msgsDao.selectType(1);
    }

   /* @GetMapping("/check")
    public Integer checkMsg(){
        int num = msgsDao.checkType();
        return num;
    }*/
}
