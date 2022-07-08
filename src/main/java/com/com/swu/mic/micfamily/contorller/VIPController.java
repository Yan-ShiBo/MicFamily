package com.com.swu.mic.micfamily.contorller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.VIPDao;
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
    @Autowired
    VIPDao vipDao;


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


    @PutMapping("/find")
    public Page<VIP> search(@RequestParam String userName, @RequestParam Integer currented, @RequestParam Integer size) {

        System.out.println(userName + "   " + currented + "   " + size);

        Page<VIP> VIPPage = new Page<>();
        List<VIP> vipList = vipDao.search("%" + userName + "%", currented * size, size);
        int max = vipDao.findCount("%" + userName + "%");
        System.out.println(max / size);
        if (max % size == 0) {
            VIPPage.setTotal(max / size - 1);
        } else
            VIPPage.setTotal(max / size);
        VIPPage.setRecords(vipList);
        return VIPPage;


    }


    @GetMapping("/page")
    public Page<VIP> getpage(@RequestParam Integer currented, @RequestParam Integer size) {
        System.out.println(currented + "   " + size);

        Page<VIP> VIPPage = new Page<>();
        List<VIP> vipList = vipDao.selectPages(currented * size, size);
        int max = vipDao.selectCount();
        System.out.println(max / size);
        if (max % size == 0) {
            VIPPage.setTotal(max / size - 1);
        } else
            VIPPage.setTotal(max / size);
        VIPPage.setRecords(vipList);
        return VIPPage;
    }


}
