package com.upload.file.apps.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upload.file.apps.domain.AdUserLogin;
import com.upload.file.apps.service.AdUserLoginService;
import com.upload.file.apps.mapper.AdUserLoginMapper;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【ad_user_login(管理员登录行为信息表)】的数据库操作Service实现
* @createDate 2022-07-04 19:35:44
*/
@Service
public class AdUserLoginServiceImpl extends ServiceImpl<AdUserLoginMapper, AdUserLogin>
    implements AdUserLoginService{

}




