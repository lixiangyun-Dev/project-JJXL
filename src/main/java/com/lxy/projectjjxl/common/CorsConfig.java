package com.lxy.projectjjxl.common;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/28 13:49
 */
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 是否发送Cookie
                .allowCredentials(true)
                // 放行哪些原始域
                .allowedOrigins("*")
                // 放行哪些请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // 放行哪些原始请求头部信息
                .allowedHeaders("*")
                // 暴露哪些头部信息
                .exposedHeaders("*");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //文件磁盘图片url 映射
//        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
//        registry.addResourceHandler("/image/**").addResourceLocations("file:///E:/image/");
//    }
}
