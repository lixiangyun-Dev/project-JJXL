package com.lxy.projectjjxl.controller;

import com.lxy.projectjjxl.common.ApiResult;
import com.lxy.projectjjxl.domain.entity.Employee;
import com.lxy.projectjjxl.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/10/15 16:01
 */


@RestController
@Slf4j
@RequestMapping
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ApiResult upload(MultipartFile file,Employee employee) throws IOException {
        String uploadFileName = fileUploadService.uploadFile(file,employee);
        return ApiResult.success(uploadFileName);
    }
}
