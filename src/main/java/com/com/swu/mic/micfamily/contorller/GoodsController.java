package com.com.swu.mic.micfamily.contorller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.GoodsDao;
import com.com.swu.mic.micfamily.dao.OrderDao;
import com.com.swu.mic.micfamily.dao.RoomDao;
import com.com.swu.mic.micfamily.domain.Goods;
import com.com.swu.mic.micfamily.domain.Order;
import com.com.swu.mic.micfamily.domain.Room;
import com.com.swu.mic.micfamily.domain.buyGoods;
import com.com.swu.mic.micfamily.service.GoodsService;
import com.com.swu.mic.micfamily.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/5 星期二 11:48
 * @ package name： com.com.swu.mic.micfamily.contorller
 * @ Project name： MicFamily
 * @ Description：
 */
@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    OrderDao orderDao;


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Goods goods) {
//        if (goods.getPassword().length() < 3) {
//            return false;
//        }
//        int scores = Integer.valueOf(goods.getScores());
//        if (scores < 1)
//            return false;

//        System.out.println(goods);

        return goodsService.save(goods);
    }

    @DeleteMapping("/{id}")
    public boolean deletegoods(@PathVariable int id) {

        return goodsService.removeById(id);
    }

    @GetMapping("/all")
    public List<Goods> GetGoods() {


        return goodsService.list();
    }

    @GetMapping("/{id}")
    public Goods Updategoods(@PathVariable int id) {

        return goodsService.getById(id);
    }

    @PutMapping("/update")
    public boolean updatagoods(@RequestBody Goods goods) {
        return goodsService.updateById(goods);
    }


    @PutMapping("/find")
//    public List<Goods> finduser(@RequestParam String goodsName) {
//
//        List<Goods> goodsList = goodsDao.getByName("%" + goodsName + "%");
//        return goodsList;
//    }
    public Page<Goods> search(@RequestParam String goodsName, @RequestParam Integer currented, @RequestParam Integer size) {

        System.out.println(goodsName + "   " + currented + "   " + size);

        Page<Goods> GoodsPage = new Page<>();
        List<Goods> goodsList = goodsDao.search("%" + goodsName + "%", currented * size, size);
        int max = goodsDao.findCount("%" + goodsName + "%");
//        System.out.println(max / size);
        if (max % size == 0) {
            GoodsPage.setTotal(max / size - 1);
        } else
            GoodsPage.setTotal(max / size);
        GoodsPage.setRecords(goodsList);
        return GoodsPage;


    }


    @GetMapping("/page")
    public Page<Goods> getpage(@RequestParam Integer currented, @RequestParam Integer size) {
//        System.out.println(currented + "   " + size);

        Page<Goods> GoodsPage = new Page<>();
        List<Goods> goodsList = goodsDao.selectPages(currented * size, size);
        int max = goodsDao.selectCount();
//        System.out.println(max / size);
        if (max % size == 0) {
            GoodsPage.setTotal(max / size - 1);
        } else
            GoodsPage.setTotal(max / size);
        GoodsPage.setRecords(goodsList);
//        System.out.println(GoodsPage+"---------------");
        return GoodsPage;
    }


    //购买商品的后端实现
    @GetMapping("/buyGoods")
    public buyGoods getButGoods(@RequestParam Integer manager_id, @RequestParam Integer goodsId) {
//        System.out.println("099128301724123");
        buyGoods buygoods = new buyGoods();
        Room room;
        Order order;
        room = roomDao.getcoRoomName(manager_id);
        if (room == null) {
            buygoods.setFlag(false);
            buygoods.setMsg("您还没有预定包间");
            order = new Order();
            buygoods.setOrder(order);
            return buygoods;
        }
//        查询订单
        String roomName = room.getRoomName();
        order = orderDao.getcoOrder(roomName);

//        订单如果为空，则创建订单并绑定包间
        if (order == null) {
            order = new Order();
            order.setCoRoom(roomName);
            order.setOrderInfo("用户" + manager_id + "的订单");
            orderService.save(order);
        }
        Integer orderId = order.getId();

        Goods goods = goodsService.getById(goodsId);
        goods.setOrderId(orderId);
        goodsService.updateById(goods);
        System.out.println(orderId + "   " + goodsId);
        buygoods.setFlag(true);
        buygoods.setMsg("购买成功");
        return buygoods;

    }


}
