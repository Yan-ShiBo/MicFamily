package com.com.swu.mic.micfamily.contorller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.GoodsDao;
import com.com.swu.mic.micfamily.dao.OrderDao;
import com.com.swu.mic.micfamily.dao.RoomDao;
import com.com.swu.mic.micfamily.domain.Goods;
import com.com.swu.mic.micfamily.domain.Order;
import com.com.swu.mic.micfamily.domain.Room;
import com.com.swu.mic.micfamily.domain.order_inquiry;
import com.com.swu.mic.micfamily.service.OrderService;
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
    private RoomDao roomDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderService orderService;

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
    public Page<Room> findBigroom(@RequestParam Integer BigCurrented, @RequestParam Integer BigSize) {

//        System.out.println(BigCurrented + " ---+++--- " + BigSize);
        Page<Room> RoomPage = new Page<>();
        List<Room> roomList = roomDao.getBigroom(BigCurrented * BigSize, BigSize);
        for (Room i : roomList) {
            if (i.getRoomType().equals("1")) {
                i.setRoomType("大包");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
        }
        int max = roomDao.CountBig();
        System.out.println(max / BigSize);
        if (max % BigSize == 0) {
            RoomPage.setTotal(max / BigSize - 1);
        } else
            RoomPage.setTotal(max / BigSize);

        RoomPage.setRecords(roomList);
        return RoomPage;
    }


    @GetMapping("/medium")
    public Page<Room> findMediumroom(@RequestParam Integer MediumCurrented, @RequestParam Integer MediumSize) {

//        System.out.println(MediumCurrented + " ---+++--- " + MediumSize);
        Page<Room> RoomPage = new Page<>();
        List<Room> roomList = roomDao.getMediumroom(MediumCurrented * MediumSize, MediumSize);
        for (Room i : roomList) {
            if (i.getRoomType().equals("2")) {
                i.setRoomType("中包");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
        }

        int max = roomDao.CountMedium();
        System.out.println(max / MediumSize);
        if (max % MediumSize == 0) {
            RoomPage.setTotal(max / MediumSize - 1);
        } else
            RoomPage.setTotal(max / MediumSize);

        RoomPage.setRecords(roomList);
        return RoomPage;

    }

    @GetMapping("/small")
    public Page<Room> findSmallroom(@RequestParam Integer SmallCurrented, @RequestParam Integer SmallSize) {

//        System.out.println(SmallCurrented + " ---+++--- " + SmallSize);
        Page<Room> RoomPage = new Page<>();
        List<Room> roomList = roomDao.getSmallroom(SmallCurrented * SmallSize, SmallSize);
        for (Room i : roomList) {
            if (i.getRoomType().equals("3")) {
                i.setRoomType("小包");
            }
            if (i.getStatus().equals("2")) {
                i.setStatus("未使用");
            }
        }

        int max = roomDao.CountSmall();
        System.out.println(max / SmallSize);
        if (max % SmallSize == 0) {
            RoomPage.setTotal(max / SmallSize - 1);
        } else
            RoomPage.setTotal(max / SmallSize);

        RoomPage.setRecords(roomList);
        return RoomPage;

    }


    //所有包间的查询+分页
    @GetMapping("/AllRoom")
    public Page<Room> findAllRoom(@RequestParam Integer currented, @RequestParam Integer size) {

//        System.out.println(currented + " ---+++--- " + size);

        Page<Room> RoomPage = new Page<>();
        List<Room> roomList = roomDao.search1(currented * size, size);
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
        }

        int max = roomDao.findCount1();
//        System.out.println(max / size);
        if (max % size == 0) {
            RoomPage.setTotal(max / size - 1);
        } else
            RoomPage.setTotal(max / size);

        RoomPage.setRecords(roomList);
        return RoomPage;


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

//                System.out.println(orderId);
                goodsList = goodsDao.getByOrderId(orderId);


//                System.out.println(goodsDao.getByOrderId(orderId));
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
//        System.out.println(id + "-----" + managerId);

        Room room = roomDao.getcoRoomName(managerId);
//        System.out.println("2222222222222222111111111111111111" + room);
        if (room == null) {
            room = new Room();
//            System.out.println(managerId + "111111111111111111" + room);
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


    //订单退订
    @DeleteMapping("/removeid")
    public String removeId(@RequestParam("id") Integer id, @RequestParam("managerId") Integer managerId) {
//        System.out.println(id + "-----" + managerId);

        Room room = roomDao.getcoRoomName(managerId);
        if (room == null) {
            return "对不起，您还没有预订过包间";
        } else {
            String roomName = room.getRoomName();
            roomDao.updateID(managerId);

            Order order = orderDao.getcoOrder(roomName);
            if (order != null) {
                Integer orderId = order.getId();
                orderService.removeById(orderId);

                List<Goods> goodsList = goodsDao.getByOrderId(orderId);
                for (Goods i : goodsList) {
                    i.setOrderId(null);
                    goodsDao.updateID(i.getId());
                }
            }
        }
//            System.out.println(managerId + "111111111111111111" + room);
        return "您已成功结算订单";
    }






}
