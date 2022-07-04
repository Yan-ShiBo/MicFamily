package com.com.swu.mic.micfamily.contorller;


import com.com.swu.mic.micfamily.domain.VIP;
import com.com.swu.mic.micfamily.service.VIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/VIP")
@CrossOrigin
public class VIPController {
    @Autowired
    private VIPService vipService;


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody VIP vip) {
        if (vip.getPassword().length() < 3) {
            return false;
        }
        int scores = Integer.valueOf(vip.getScores());
        if (scores < 1)
            return false;

        return vipService.save(vip);
    }

    @DeleteMapping("/{id}")
    public boolean deletevip(@PathVariable int id) {

        return vipService.removeById(id);
    }

    @GetMapping("/all")
    public List<VIP> GetVIP() {


        return vipService.list();
    }

    @GetMapping("/{id}")
    public VIP Updatevip(@PathVariable int id) {
        //return managerService.update(manager);
        return vipService.getById(id);
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody VIP vip) {
        return vipService.updateById(vip);
    }
}
