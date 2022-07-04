package com.com.swu.mic.micfamily.contorller;

import com.com.swu.mic.micfamily.domain.Room;
import com.com.swu.mic.micfamily.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Room room) {


        return roomService.save(room);
    }

    @DeleteMapping("/{id}")
    public boolean deleteroom(@PathVariable int id) {

        return roomService.removeById(id);
    }

    @GetMapping("/all")
    public List<Room> GetRoom() {
        List<Room> listdata = roomService.list();
        List<Room> listdata1 = new ArrayList<>();
        for (Room i : listdata) {
            if (i.getRoomType().equals("1")) {
                i.setRoomType("大包");
            }
            if (i.getRoomType().equals("2")) {
                i.setRoomType("中包");
            }
            if (i.getRoomType().equals("3")) {
                i.setRoomType("小包");
            }
            if (i.getStatus().equals("1")) {
                i.setStatus("正在使用");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
            if (i.getStatus().equals("3")) {
                i.setStatus("正在打扫");
            }
            if (i.getStatus().equals("4")) {
                i.setStatus("已预订");
            }
            listdata1.add(i);
        }
        return listdata1;
    }

    @GetMapping("/{id}")
    public Room Updateroom(@PathVariable int id) {
        //return managerService.update(manager);
        return roomService.getById(id);
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody Room room) {
        return roomService.updateById(room);
    }

}
