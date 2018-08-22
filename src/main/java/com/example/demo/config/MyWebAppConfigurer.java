package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 拦截的请求
     */
    String[] pathPatterns = new String[]{"/**"};

    /**
     * 不拦截的请求
     */
    String[] excludePathPatterns = new String[]{"/css/**","*.js","/images/**"};


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new SpringInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns);
        super.addInterceptors(registry);
    }
}
