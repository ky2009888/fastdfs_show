package com.upload.file.apps.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.log.StaticLog;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upload.file.apps.domain.AppHttpCodeEnum;
import com.upload.file.apps.domain.ResponseResult;
import com.upload.file.apps.domain.WmMaterial;
import com.upload.file.apps.domain.WmUser;
import com.upload.file.apps.service.WmMaterialService;
import com.upload.file.apps.mapper.WmMaterialMapper;
import com.upload.file.apps.utils.FastDfsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Lenovo
 * @description 针对表【wm_material(自媒体图文素材信息表)】的数据库操作Service实现
 * @createDate 2022-07-05 15:05:07
 */
@Service
public class WmMaterialServiceImpl extends ServiceImpl<WmMaterialMapper, WmMaterial>
        implements WmMaterialService {
    /**
     * 获取文件服务器的基础路径.
     */
    @Value("${FILE_SERVER_URL}")
    private String fileServerUrl;
    /**
     * 注入FastDfs客户端操作的类.
     */
    @Resource
    private FastDfsClient fastDfsClient;
    /**
     * 注入redis实例.
     */
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 封装文件上传的方法.
     *
     * @param uploadFile 文件类.
     * @return ResponseResult.
     */
    @Override
    public ResponseResult uploadPicture(int userId, MultipartFile uploadFile) throws Exception {
        //获取当前用户
        WmUser user = (WmUser) redisTemplate.opsForValue().get(userId);
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        //验证参数
        if (uploadFile == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //上传图片至FastDfs
        String originalFilename = uploadFile.getOriginalFilename();
        //文件扩展名
        String extName = FileNameUtil.extName(originalFilename);
        //如果文件后缀名不是gif png jpg jpeg 则不允许上传
        if (!extName.matches("(gif|png|jpg|jpeg)")) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_IMAGE_FORMAT_ERROR);
        }
        WmMaterial wmMaterial;
        int result = 0;
        //进行文件上传
        try {
            String filePath = fastDfsClient.uploadFile(uploadFile.getBytes(), extName);
            StaticLog.info("文件上传之后的路径:{}", filePath);
            wmMaterial = new WmMaterial();
            wmMaterial.setCreatedTime(LocalDateTime.now());
            wmMaterial.setType(0);
            wmMaterial.setUrl(fileServerUrl + filePath);
            wmMaterial.setIsCollection(0);
            wmMaterial.setUserId(user.getId());
            result = getBaseMapper().insert(wmMaterial);
        } catch (IOException e) {
            StaticLog.error("当前用户{}，上传文件{}至服务器失败", user.getId(), originalFilename);
            return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
        }
        if (result < 0) {
            return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
        }
        //上传成功后，保存一条信息到表wm_material
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}




