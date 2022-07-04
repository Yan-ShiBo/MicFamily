package com.com.swu.mic.micfamily.contorller;

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


    @PostMapping("/management")
    public boolean Postmanagement(@RequestBody Notice notice) {

        return noticeService.save(notice);
    }

    @PutMapping("/update")
    public boolean updatauser(@RequestBody Notice notice) {
        return noticeService.updateById(notice);
    }

    @DeleteMapping("/{id}")
    public boolean deletemanager(@PathVariable int id) {

        return noticeService.removeById(id);
    }

    @GetMapping("/all")
    public List<NoticeStr> Getmanagement() {
        List<NoticeStr> noticeStrList = new ArrayList<>();

        ;
        for (Notice notice : noticeService.list()) {
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
}
