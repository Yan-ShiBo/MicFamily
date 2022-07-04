package com.com.swu.mic.micfamily.contorller;


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
}
