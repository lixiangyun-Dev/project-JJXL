package com.lxy.projectjjxl.service.Impl;

import com.lxy.projectjjxl.common.ApiResult;
import com.lxy.projectjjxl.domain.entity.Employee;
import com.lxy.projectjjxl.mapper.EmployeeMapper;
import com.lxy.projectjjxl.service.FileUploadService;
import com.lxy.projectjjxl.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/10/15 16:05
 */


@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${localUploadPathImg}")
    private String localUploadPathImg;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Override
    public String uploadFile(MultipartFile file,Employee employee) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("新文件名为：{}",newFileName);
//        String pathName = localUploadPathImg + newFileName;
//        employee.setImage(pathName);
//
//        log.info("图片插入数据库成功: {}",pathName);
//        File newFile = new File(pathName);
//        file.transferTo(newFile);
//        log.info("图片上传服务器成功: {}",newFile);
//        return pathName;

        //调用阿里云oss工具类上传文件
        String url = aliOSSUtils.upload(file);
        log.info("文件上传成功，文件访问url: {}",url);

        return url;
    }
}
