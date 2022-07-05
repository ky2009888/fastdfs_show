package com.upload.file.apps.controller;

import com.upload.file.apps.domain.AdUserLogin;
import com.upload.file.apps.service.AdUserLoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/login1")
public class AdUserLoginController {
    /**
     * 注入属性.
     */
    @Resource
    private AdUserLoginService adUserLoginService;

    @GetMapping("/list")
    @ResponseBody
    @CrossOrigin
    public List<AdUserLogin> listUsers() {
        return adUserLoginService.list();
    }
}
