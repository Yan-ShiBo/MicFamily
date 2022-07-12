package com.com.swu.mic.micfamily.contorller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.com.swu.mic.micfamily.dao.ManagerDao;
import com.com.swu.mic.micfamily.domain.Manager;
import com.com.swu.mic.micfamily.service.ManagerService;
import com.com.swu.mic.micfamily.solution.candy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public Manager check(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) {
        System.out.println(userName + "---" + password);
        List<Manager> listdata = managerService.list();


        if (userName == null || userName.equals("")) {
            System.out.println("用户名为空");
            return null;
        }
        if (password == null || password.equals("")) {
            System.out.println("密码为空");
            return null;
        }



        for (Manager i : listdata) {
//            System.out.println(i.getUserName() + "---" + i.getPassword());
//            System.out.println(userName + "+++" + password);
//            System.out.println(i.getPassword().equals(userName));
//            System.out.println(i.getUserName().equals(password));
            if (i.getPassword().equals(password) && i.getUserName().equals(userName)) {
                System.out.println("登录成功" + i);
//               request.getSession().setAttribute("name","zhangsan");
//                request.getSession().setAttribute("manager", i);

//                return i.getPermission();
                return i;
//                if (i.getPermission() == 1)
//                    return 1;
//                else if (i.getPermission() == 2)
//                    return 2;
//                else if (i.getPermission() == 3)
//                    return 3;
//                else if (i.getPermission() == 4)//管理员
//                    return 4;
//                else
//                    return 0;
            }
        }
        System.out.println(userName + "  登入失败  " + password);
        return null;


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
        List<Manager> managerList = managerDao.selectPages(currented * size, size);
        int max = managerDao.selectCount();
        System.out.println(max / size);
        ManagerPage.setTotal(max / size);
        ManagerPage.setRecords(managerList);
        return ManagerPage;
    }

    @GetMapping("/play")
    public Integer play1(@RequestParam String score) {
        System.out.println(score);
        String[] arr = score.split("\\s+");
        List<Integer> arr2 = new ArrayList<>();
        for (String i : arr) {
            int x = Integer.parseInt(i);
            arr2.add(x);
        }
        Integer[] array2 = arr2.toArray(new Integer[arr2.size()]);
        candy c = new candy();

        return c.candy(array2);
    }

}
