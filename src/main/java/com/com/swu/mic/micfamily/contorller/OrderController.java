package com.com.swu.mic.micfamily.contorller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.OrderDao;
import com.com.swu.mic.micfamily.domain.Order;
import com.com.swu.mic.micfamily.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    OrderDao orderDao;


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Order order) {

        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    public boolean deleteorder(@PathVariable int id) {

        return orderService.removeById(id);
    }

    @GetMapping("/all")
    public List<Order> GetOrder() {

        return orderService.list();
    }

    @GetMapping("/update")
    public boolean Updateorder(@RequestBody Order order) {

        return true;
    }

    @GetMapping("/{id}")
    public Order Updateorder(@PathVariable int id) {
        //return managerService.update(manager);
        return orderService.getById(id);
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody Order order) {
        return orderService.updateById(order);
    }

    @PutMapping("/find")
//    public List<Order> findroom(@RequestParam String coRoom) {
//
//        List<Order> orderList = orderDao.getByName("%" + coRoom + "%");
//        return orderList;
//    }
    public Page<Order> search(@RequestParam String coRoom, @RequestParam Integer currented, @RequestParam Integer size) {

        System.out.println(coRoom + "   " + currented + "   " + size);

        Page<Order> OrderPage = new Page<>();
        List<Order> orderList = orderDao.search("%" + coRoom + "%", currented * size, size);
        int max = orderDao.findCount("%" + coRoom + "%");
        System.out.println(max / size);
        if (max % size == 0) {
            OrderPage.setTotal(max / size - 1);
        } else
            OrderPage.setTotal(max / size);
        OrderPage.setRecords(orderList);
        return OrderPage;


    }


    @GetMapping("/page")
    public Page<Order> getpage(@RequestParam Integer currented, @RequestParam Integer size) {
        System.out.println(currented + "   " + size);

        Page<Order> OrderPage = new Page<>();
        List<Order> orderList = orderDao.selectPages(currented * size, size);
        int max = orderDao.selectCount();
        System.out.println(max / size);
        if (max % size == 0) {
            OrderPage.setTotal(max / size - 1);
        } else
            OrderPage.setTotal(max / size);
        OrderPage.setRecords(orderList);
        return OrderPage;
    }

    @GetMapping("/orderbyid")
    public Order GetOrderById(@RequestParam String roomId) {
//        System.out.println(roomId);
        Order orderbyid = orderDao.getOrderById(roomId);
//          System.out.println(orderbyid);
        return orderbyid;
    }

}
