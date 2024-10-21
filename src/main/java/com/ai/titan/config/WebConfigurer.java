package com.ai.titan.config;

import com.ai.titan.Interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfigurer implements WebMvcConfigurer {

//    //注入
//    @Autowired
//    private AuthInterceptor authInterceptor;
//
//    //将拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor)
//                .addPathPatterns("/**")//拦截所有的 url
//                .excludePathPatterns("/user/login");//排除url: /user/login (登录)
////                .excludePathPatterns("/user/reg") //排除url: /user/reg   (注册)
////                .excludePathPatterns("/image/**")//排除 image(图像) 文件夹下的所有文件
////                .excludePathPatterns("/**/*.js")//排除任意深度目录下的所有".js"文件
////                .excludePathPatterns("/**/*.css");
//    }
}
