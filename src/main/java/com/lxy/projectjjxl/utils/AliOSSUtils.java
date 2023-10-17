package com.lxy.projectjjxl.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/10/17 15:28
 */

@Component
public class AliOSSUtils {
    private String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "LTAI5tCqZvitJjFc8Tn9Cb9c";
    private String accessKeySecret = "0kwKQMwaZ9I4bjrbI0yrWsPJtlvzJZ";
    private String bucketName = "java-oos";


    public String upload(MultipartFile file) throws IOException {
        //获取上传文件的输入流
        InputStream inputStream = file.getInputStream();

        //避免文件被覆盖
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String extName = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extName;

        //文件上传到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName,newFileName,inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0]+"//"+bucketName+"."+endpoint.split("//")[1]+"/"+newFileName;
        //关闭ossClient
        ossClient.shutdown();
        return url;
    }
}
