package com.com.swu.mic.micfamily.contorller;


import com.com.swu.mic.micfamily.dao.MsgsDao;
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

    public boolean saveMsg() {
        Msgs msgs = new Msgs();
        msgs.setMsgsCont("有新的包间预定");
        msgs.setType(1);
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
}
