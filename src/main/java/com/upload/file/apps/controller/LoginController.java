package com.upload.file.apps.controller;

import com.upload.file.apps.domain.AppHttpCodeEnum;
import com.upload.file.apps.domain.PageResponseResult;
import com.upload.file.apps.domain.ResponseResult;
import com.upload.file.apps.domain.WmUser;
import com.upload.file.apps.service.WmUserService;
import com.upload.file.apps.utils.AppJwtUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    /**
     * 注入用户相关的实例.
     */
    @Resource
    private WmUserService wmUserService;
    /**
     * 注入redis实例.
     */
    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/in")
    @ResponseBody
    @CrossOrigin
    public ResponseResult listUsers(HttpServletRequest request, String username, String password) {
        //验证参数
        if (StringUtils.isEmpty(password)) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        List<WmUser> wmUserList = wmUserService.list();
        WmUser apUser = wmUserList.get(0);
        if (apUser == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        if (!password.equals(apUser.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        apUser.setPassword("");
        Map<String, Object> map = new HashMap<>();
        map.put("token", AppJwtUtil.getToken(apUser));
        map.put("user", apUser);
        String sessionId = request.getSession().getId();
        redisTemplate.opsForValue().set(apUser.getId(), apUser);
        return PageResponseResult.okResult(map);
    }
}
