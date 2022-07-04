package com.com.swu.mic.micfamily.contorller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.ManagerDao;
import com.com.swu.mic.micfamily.domain.Manager;
import com.com.swu.mic.micfamily.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
@CrossOrigin
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ManagerDao managerDao;

    @GetMapping
    public Integer check(@RequestParam String userName, @RequestParam String password) {

        List<Manager> listdata = managerService.list();


        if (userName == null || userName.equals("")) {
            System.out.println("用户名为空");
            return 0;
        }
        if (password == null || password.equals("")) {
            System.out.println("密码为空");
            return 0;
        }


        Manager manager = new Manager();
        manager.setPassword(password);
        manager.setUserName(userName);

        for (Manager i : listdata) {
            //System.out.println(i.getUserName() + "---" + i.getPassword());System.out.println(manager.getUserName() + "+++" + manager.getPassword() );
            if (i.getPassword().equals(manager.getPassword()) && i.getUserName().equals(manager.getUserName())) {
                System.out.println("登录成功");
                if (i.getPermission() == 1)
                    return 1;
                else if (i.getPermission() == 2)
                    return 2;
                else if (i.getPermission() == 3)
                    return 3;
                else if (i.getPermission() == 4)//管理员
                    return 4;
                else
                    return 0;
            }
        }
        System.out.println(userName + "  登入失败  " + password);
        return 0;


    }

    @GetMapping("/signin")
    public int check(@RequestParam String userName, @RequestParam String password, @RequestParam Integer permission) {


        System.out.println(userName + "  ------  " + password);

        if (password.length() < 3 || userName.length() < 3) {
            return 100;
        }
        if (permission != 1 && permission != 2 && permission != 3 && permission != 4)
            return 101;

        Manager manager = new Manager();
        manager.setPassword(password);
        manager.setUserName(userName);
        manager.setPermission(permission);
        int a = 0;
        try {
            managerService.save(manager);
            a = 1;
        } catch (Exception e) {
            System.out.println("错误");
        }
        System.out.println(userName + "返回" + password);


        return a;


    }


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Manager manager) {
        if (manager.getPassword().length() < 3 || manager.getUserName().length() < 3) {
            return false;
        }
        int permission = Integer.valueOf(manager.getPermission());
        if (permission != 1 && permission != 2 && permission != 3 && permission != 4)
            return false;

        return managerService.save(manager);
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody Manager manager) {
        return managerService.updateById(manager);
    }

    @DeleteMapping("/{id}")
    public boolean deletemanager(@PathVariable int id) {

        return managerService.removeById(id);
    }

    @GetMapping("/all")
    public List<Manager> Getmanagement() {
        return managerService.list();
    }

    @GetMapping("/{id}")
    public Manager Updatemanager(@PathVariable int id) {

        return managerService.getById(id);
    }

    @PutMapping("/find")
    public List<Manager> finduser(@RequestParam String userName) {

        List<Manager> managerList = managerDao.getByName("%" + userName + "%");
        return managerList;
    }


    @GetMapping("/page")
    public Page<Manager> getpage(@RequestParam Integer currented, @RequestParam Integer size) {
        System.out.println(currented + "   " + size);

        Page<Manager> ManagerPage = new Page<>();
        List<Manager> managerList = managerDao.selectPages(currented, size);
        int max = managerDao.selectCount();
        System.out.println(max / size);
        ManagerPage.setTotal(max / size);
        ManagerPage.setRecords(managerList);
        return ManagerPage;
    }


}
