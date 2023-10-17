package com.lxy.projectjjxl.service;

import com.lxy.projectjjxl.domain.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/10/15 16:05
 */
public interface FileUploadService {
    String uploadFile(MultipartFile file, Employee employee) throws IOException;
}
