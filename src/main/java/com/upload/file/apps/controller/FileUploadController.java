package com.upload.file.apps.controller;

import com.upload.file.apps.domain.ResponseResult;
import com.upload.file.apps.service.WmMaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
@Controller
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 注入文件上传对象.
     */
    @Resource
    private WmMaterialService wmMaterialService;
    @GetMapping("/upload")
    public String upload() {
        return "fileUpload";
    }
    /**
     * 上传文件.
     *
     * @param uploadFile 上传文件对象.
     * @return ResponseResult.
     */
    @PostMapping("/uploadImage")
    @ResponseBody
    public ResponseResult upload(@RequestParam(value = "uploadFile")MultipartFile uploadFile) throws Exception {
        int userId = 1;
        return wmMaterialService.uploadPicture(userId,uploadFile);
    }
}
