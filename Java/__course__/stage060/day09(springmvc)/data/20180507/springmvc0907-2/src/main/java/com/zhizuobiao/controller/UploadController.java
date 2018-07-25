package com.zhizuobiao.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @RequestMapping("/upload.do")
    @ResponseBody
    public String uploadImage(
            @RequestParam(value = "uploadImg", required = true) MultipartFile file) {

        if (file.isEmpty()) {
            return "image is empty!!!!";
        }

        String savePath = "D:\\1_java\\upload_imgs";
        // UUID 随机字符串
        String uuidName = UUID.randomUUID().toString();

        // 获取上传文件名字
        String originaFileName = file.getOriginalFilename();
        // 截取文件名中的后缀，eg：.jpg .png
        String suffix = originaFileName.substring(originaFileName.lastIndexOf(".") + 1, originaFileName.length());

        // UUID + . + jpg
        String newFileName = uuidName + "." + suffix;

        File imageFile = new File(savePath, newFileName);

        try {
        	// 保存
            file.transferTo(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回字符串内容
        return "http://localhost:8080/img/" + newFileName;
    }
}
