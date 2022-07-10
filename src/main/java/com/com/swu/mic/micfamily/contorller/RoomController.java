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

    @GetMapping("/AllRoom")
    public List<Room> findAllRoom() {
        List<Room> roomList = roomDao.getAllRoom();
        List<Room> roomList1 = new ArrayList<>();
        for (Room i : roomList) {
            if (i.getRoomType().equals("3")) {
                i.setRoomType("小包");
            } else if (i.getRoomType().equals("2")) {
                i.setRoomType("中包");
            } else if (i.getRoomType().equals("1")) {
                i.setRoomType("大包");
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
        room = roomDao.getcoRoomName(manager_id);
        if (room == null) {
            room = new Room();
            order = new Order();
            goodsList = new ArrayList<Goods>();
            r.setRoom(room);
            r.setOrder(order);
            r.setGoodsList(goodsList);
            r.setFlag(false);
            r.setMsg("您还没有订单!");
        } else {
            try {
//            room = roomDao.getcoRoomName(manager_id);
                String roomName = room.getRoomName();
                r.setRoom(room);

                order = orderDao.getcoOrder(roomName);
                if (order == null)
                    order = new Order();

                r.setOrder(order);

                Integer orderId = order.getId();

                System.out.println(orderId);
                goodsList = goodsDao.getByOrderId(orderId);


                System.out.println(goodsDao.getByOrderId(orderId));
                r.setGoodsList(goodsList);
                r.setFlag(true);
                r.setMsg("订单详情已查询!");
            } catch (Exception e) {
                r.setFlag(false);
                r.setMsg("search failed!");
            }
        }

        return r;
    }

//    @GetMapping("/{id}")
//    public Boolean Updateroom(@PathVariable int id) {
//        Room room = new Room();
//        room = roomService.getById(id);
//        room.setStatus("4");
//        roomService.updateById(room);
//        return true;
//    }

    @GetMapping("/{id}")
    public Room Updateroom(@PathVariable int id) {
        return roomService.getById(id);
    }

    @GetMapping("/addid")
    public String addID(@RequestParam int id, @RequestParam int managerId) {
        System.out.println(id + "-----" + managerId);

        Room room = roomDao.getcoRoomName(managerId);
        System.out.println("2222222222222222111111111111111111" + room);
        if (room == null) {
            room = new Room();
            System.out.println(managerId + "111111111111111111" + room);
            room.setId(id);
            room.setManagerId(managerId);
            room.setStatus("4");
            roomService.updateById(room);
            System.out.println(managerId + "您已成功预订包间" + room);
            return "您已成功预订包间";
        } else
            System.out.println(managerId + "您已预订过包间" + room);
        return "对不起，您已预订过包间";
    }


}
