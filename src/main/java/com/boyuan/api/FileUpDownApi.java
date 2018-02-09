package com.boyuan.api;

import com.boyuan.base.AppConfiguration;
import com.boyuan.base.ErrorMsg;
import com.boyuan.base.RestResult;
import com.boyuan.enums.RestApiCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author jiangbo
 * @time 2018/1/4
 */
@Controller
@RequestMapping("/resource")
public class FileUpDownApi {

    public static Logger logger = LoggerFactory.getLogger(FileUpDownApi.class);

    @Autowired
    private AppConfiguration appConfiguration;

    /**
     * 下载
     */
    @ResponseBody
    @RequestMapping("/download")
    public void download(@RequestParam("id") Long id){

    }

    /**
     * 上传
     */
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public RestResult upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return new RestResult(RestApiCodeEnum.FAIL.getCode(),ErrorMsg.FILE_IS_EMPTY,null);
        }

        String originalFileName = file.getOriginalFilename();
        logger.info("上传的文件名为:" + originalFileName);
        String fileSuffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + fileSuffix;

        String uploadPath = appConfiguration.getUpload() + newFileName;
        File dest = new File(uploadPath);
        // 检测是否存在目录,不存在则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            // TODO 添加资源到数据库

            return new RestResult(RestApiCodeEnum.SUCCESS.getCode(),ErrorMsg.UPLOAD_FILE_SUCCESS,null);
        } catch (Exception e) {
            logger.error("upload file fail:{}",e);
        }
        return new RestResult(RestApiCodeEnum.FAIL.getCode(),ErrorMsg.UPLOAD_FILE_FAIL,null);
    }
}
