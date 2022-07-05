package com.com.swu.mic.micfamily.contorller;

import com.com.swu.mic.micfamily.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
