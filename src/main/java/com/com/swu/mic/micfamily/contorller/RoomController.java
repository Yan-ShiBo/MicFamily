package com.com.swu.mic.micfamily.contorller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.GoodsDao;
import com.com.swu.mic.micfamily.dao.OrderDao;
import com.com.swu.mic.micfamily.dao.RoomDao;
import com.com.swu.mic.micfamily.domain.Goods;
import com.com.swu.mic.micfamily.domain.Order;
import com.com.swu.mic.micfamily.domain.Room;
import com.com.swu.mic.micfamily.domain.order_inquiry;
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
    @Autowired
    RoomDao roomDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    GoodsDao goodsDao;

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
    public Boolean Updateroom(@PathVariable int id) {
        Room room = new Room();
        room = roomService.getById(id);
        room.setStatus("4");
        roomService.updateById(room);
        return true;
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody Room room) {
        return roomService.updateById(room);
    }


    @PutMapping("/find")
    public Page<Room> search(@RequestParam String roomName, @RequestParam Integer currented, @RequestParam Integer size) {

        System.out.println(roomName + "   " + currented + "   " + size);

        Page<Room> RoomPage = new Page<>();
        List<Room> roomList = roomDao.search("%" + roomName + "%", currented * size, size);
        int max = roomDao.findCount("%" + roomName + "%");
        System.out.println(max / size);
        if (max % size == 0) {
            RoomPage.setTotal(max / size - 1);
        } else
            RoomPage.setTotal(max / size);
        RoomPage.setRecords(roomList);
        return RoomPage;


    }


    @GetMapping("/big")
    public List<Room> findBigroom() {
        List<Room> roomList = roomDao.getBigroom();
        List<Room> roomList1 = new ArrayList<>();
        for (Room i : roomList) {
            if (i.getRoomType().equals("1")) {
                i.setRoomType("大包");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
            roomList1.add(i);
        }
        return roomList1;
    }

    @GetMapping("/medium")
    public List<Room> findMediumroom() {
        List<Room> roomList = roomDao.getMediumroom();
        List<Room> roomList1 = new ArrayList<>();
        for (Room i : roomList) {
            if (i.getRoomType().equals("2")) {
                i.setRoomType("中包");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
            roomList1.add(i);
        }
        return roomList1;
    }

    @GetMapping("/small")
    public List<Room> findSmallroom() {
        List<Room> roomList = roomDao.getSmallroom();
        List<Room> roomList1 = new ArrayList<>();
        for (Room i : roomList) {
            if (i.getRoomType().equals("3")) {
                i.setRoomType("小包");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
            roomList1.add(i);
        }
        return roomList1;
    }

    @GetMapping("/page")
    public Page<Room> getpage(@RequestParam Integer currented, @RequestParam Integer size) {
        System.out.println(currented + "   " + size);

        Page<Room> RoomPage = new Page<>();
        List<Room> roomList = roomDao.selectPages(currented * size, size);
        int max = roomDao.selectCount();
        System.out.println(max / size);
        if (max % size == 0) {
            RoomPage.setTotal(max / size - 1);
        } else
            RoomPage.setTotal(max / size);
        RoomPage.setRecords(roomList);
        return RoomPage;
    }

    @PutMapping("/findcoRoomName")//根据用户ID找到对应的房间名
    public order_inquiry findroomName(@RequestParam int manager_id) {
        order_inquiry r = new order_inquiry();
        Room room;
        Order order;
        List<Goods> goodsList;
        try {
            room = roomDao.getcoRoomName(manager_id);
            String roomName = room.getRoomName();
            r.setRoom(room);

            order = orderDao.getcoOrder(roomName);
            r.setOrder(order);

            Integer orderId = order.getId();

            System.out.println(orderId);
            goodsList = goodsDao.getByOrderId(orderId);
            System.out.println(goodsDao.getByOrderId(orderId));
            r.setGoodsList(goodsList);
            r.setFlag(true);

        } catch (Exception e) {
            r.setFlag(false);
            r.setMsg("search failed!");
        }
        return r;
    }

    @GetMapping("/addid")
    public Boolean addID(@RequestParam int id, @RequestParam int managerId) {
        System.out.println(id + "-----" + managerId);

        Room room = roomDao.getcoRoomName(managerId);
        if (room.equals(null)) {
            room.setManagerId(managerId);
            room.setStatus("4");
            roomService.updateById(room);
            return true;
        } else
            return false;
    }


}
