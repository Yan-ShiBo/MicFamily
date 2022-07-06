package com.com.swu.mic.micfamily.contorller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.GoodsDao;
import com.com.swu.mic.micfamily.domain.Goods;
import com.com.swu.mic.micfamily.service.GoodsService;
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
    GoodsDao goodsDao;


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Goods goods) {
//        if (goods.getPassword().length() < 3) {
//            return false;
//        }
//        int scores = Integer.valueOf(goods.getScores());
//        if (scores < 1)
//            return false;

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
    public List<Goods> finduser(@RequestParam String goodsName) {

        List<Goods> goodsList = goodsDao.getByName("%" + goodsName + "%");
        return goodsList;
    }


    @GetMapping("/page")
    public Page<Goods> getpage(@RequestParam Integer currented, @RequestParam Integer size) {
//        System.out.println(currented + "   " + size);

        Page<Goods> GoodsPage = new Page<>();
        List<Goods> goodsList = goodsDao.selectPages(currented * size, size);
        int max = goodsDao.selectCount();
//        System.out.println(max / size);
        GoodsPage.setTotal(max / size);
        GoodsPage.setRecords(goodsList);
//        System.out.println(GoodsPage+"---------------");
        return GoodsPage;
    }


}
