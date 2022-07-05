package com.com.swu.mic.micfamily.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/5 星期二 14:18
 * @ package name： com.com.swu.mic.micfamily.interceptor
 * @ Project name： MicFamily
 * @ Description：
 */
@Configuration
public class WebCondig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/")
                .excludePathPatterns("/manage/login", "/front-end/**", "/**/*.html,/**/*.css", "/**/*.css");
    }

}
