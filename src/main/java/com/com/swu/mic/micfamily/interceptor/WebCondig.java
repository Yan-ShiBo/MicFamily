package com.com.swu.mic.micfamily.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebCondig implements WebMvcConfigurer {

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoPath; //图标物理存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath; //图标映射路径

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(ProfilePhotoMapperPath + "**").addResourceLocations("file:" + ProfilePhotoPath);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println(123);
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("static/front-end/MicFamily-login/*.html", "static/front-end/MicFamily-login/*.css", "static/front-end/MicFamily-login.js", "static/front-end/MicFamily-login/**,http://localhost:8088/login");
//
                .excludePathPatterns("/front-end/**", "/**/*.html,/**/*.css", "/**/*.css");
    }

}
