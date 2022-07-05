package com.upload.file.apps.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upload.file.apps.domain.WmUser;
import com.upload.file.apps.service.WmUserService;
import com.upload.file.apps.mapper.WmUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【wm_user(自媒体用户信息表)】的数据库操作Service实现
* @createDate 2022-07-04 20:43:27
*/
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser>
    implements WmUserService{

}




