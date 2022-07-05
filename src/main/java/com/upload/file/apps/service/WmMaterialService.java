package com.upload.file.apps.service;

import com.upload.file.apps.domain.ResponseResult;
import com.upload.file.apps.domain.WmMaterial;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Lenovo
 * @description 针对表【wm_material(自媒体图文素材信息表)】的数据库操作Service
 * @createDate 2022-07-05 15:05:07
 */
public interface WmMaterialService extends IService<WmMaterial> {
    /**
     * 封装文件上传的方法.
     *
     * @param uploadFile 文件类.
     * @param userId  会话ID.
     * @return ResponseResult.
     */
    ResponseResult uploadPicture(int userId, MultipartFile uploadFile) throws Exception;
}
