package com.com.swu.mic.micfamily.contorller;

import com.com.swu.mic.micfamily.config.ObjEvent;
import com.com.swu.mic.micfamily.dao.ManagerDao;
import com.com.swu.mic.micfamily.domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class ListenSaveContorller {
    @Autowired
    public ManagerDao managerdao;
    @Autowired
    private WebApplicationContext webapplicationcontext;
    @PostMapping("/save")
    public String rest(@RequestParam Integer userId) {
        Manager manager = managerdao.selectById(userId);
        manager.setStatus(1);
        int num = managerdao.updateById(manager);
        ObjEvent objEvent = new ObjEvent("Manager:", manager, "预订房间了");
        webapplicationcontext.publishEvent(objEvent);
//        System.out.println(num+"条记录更新成功-------------------------------------------------------------");
        return num > 0 ? "成功" : "失败";

    }
}
