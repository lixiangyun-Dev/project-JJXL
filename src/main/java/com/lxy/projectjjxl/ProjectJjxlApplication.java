package com.lxy.projectjjxl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ProjectJjxlApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectJjxlApplication.class, args);
        log.info("项目已经开始启动。。。。。。。");
    }


}
