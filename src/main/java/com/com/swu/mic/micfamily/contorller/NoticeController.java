package com.com.swu.mic.micfamily.contorller;

import com.com.swu.mic.micfamily.dao.InfoDao;
import com.com.swu.mic.micfamily.dao.NoticeDao;
import com.com.swu.mic.micfamily.domain.Info;
import com.com.swu.mic.micfamily.domain.Notice;
import com.com.swu.mic.micfamily.domain.NoticeStr;
import com.com.swu.mic.micfamily.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/4 星期一 11:43
 * @ package name： com.com.swu.mic.micfamily.contorller
 * @ Project name： MicFamily
 * @ Description：
 */
@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private InfoDao infodao;

    @Autowired
    private NoticeDao noticeDao;

    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Notice notice) {
//        System.out.println(notice);
        return noticeService.save(notice);
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody Notice notice) {
        return noticeService.updateById(notice);
    }

    @GetMapping("/upinfo")
    public boolean updateinfo(@RequestParam Integer id, @RequestParam String inf) {
        System.out.println(id);
        System.out.println(inf);
        return infodao.upinfo(id, inf);
    }

    @DeleteMapping("/{id}")
    public boolean deletemanager(@PathVariable int id) {

        return noticeService.removeById(id);
    }

    @GetMapping("/all")
    public List<NoticeStr> Getmanagement() {
        List<NoticeStr> noticeStrList = new ArrayList<>();

        System.out.println("+++------------------------");
        for (Notice notice : noticeService.list()) {
            NoticeStr noticeStr = new NoticeStr();
            String dataStr = notice.getDate().toString();
            noticeStr.setDatastr(dataStr);
            noticeStr.setNotice(notice);
            noticeStrList.add(noticeStr);
        }
        return noticeStrList;
    }


    @GetMapping("/user/all")
    public List<NoticeStr> Getmanagement2() {
        List<NoticeStr> noticeStrList = new ArrayList<>();


        for (Notice notice : noticeDao.getAll()) {
            NoticeStr noticeStr = new NoticeStr();
            String dataStr = notice.getDate().toString();
            noticeStr.setDatastr(dataStr);
            noticeStr.setNotice(notice);
            noticeStrList.add(noticeStr);
        }
        return noticeStrList;
    }

    @GetMapping("/{id}")
    public Notice Updatemanager(@PathVariable int id) {
        //return managerService.update(manager);
        return noticeService.getById(id);
    }

    @GetMapping("/info")
    public Info Noticeinfo(@RequestParam int id) {
        //return managerService.update(manager);
        Info infoById = infodao.getInfoById(id);
//        System.out.println(infoById);
        return infoById;
    }

    @GetMapping("/find")
    public List<NoticeStr> Noticefind(@RequestParam String topic) {
        System.out.println(topic);
        List<Notice> noticeList = noticeDao.noticefind("%" + topic + "%");

        List<NoticeStr> noticeStrList = new ArrayList<>();
        for (Notice notice : noticeList) {
            NoticeStr noticeStr = new NoticeStr();
            String dataStr = notice.getDate().toString();
            noticeStr.setDatastr(dataStr);
            noticeStr.setNotice(notice);
            noticeStrList.add(noticeStr);
        }


        return noticeStrList;
    }
}
