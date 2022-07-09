package com.com.swu.mic.micfamily.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
@CrossOrigin
@RestController
public class PhotoController {

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath; //图标图片存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath; //图标映射路径

    @PostMapping("/api/profilePhotoUpload")
    public String profilePhotoUpload(@RequestParam("file") MultipartFile fileUpload) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用文件名重新生成
        fileName = UUID.randomUUID() + suffixName;
        try {
            //将图片保存到文件夹里
            fileUpload.transferTo(new File(ProfilePhotoSavePath + fileName));
//            model.addAttribute("thps",(ProfilePhotoMapperPath+fileName));
//              response.sendRedirect("/front-end/MicFamily-login/manage.html");
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        //   return "/manage";
    }
}
