package com.wzw.springboot.config;

import com.wzw.springboot.component.LoginHandlerInterceptor;
import com.wzw.springboot.component.MyLocaleResovler;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurer可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送wzw请求，来到success
        registry.addViewController("/wzw").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *  /**：拦截所有请求,
         *  addPathPatterns("/**"):拦截所有路径
         *  excludePathPatterns()：排除要拦截的访问路径，老版本的springboot会自动排除对静态资源的访问拦截，新版本的
         *                          要手动排除静态资源路径
          */

       /* registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/",
                "/user/login","/asserts/css/**","/asserts/js/**","/asserts/img/**","/webjars/**");*/

    }

    /**
     * 国际化
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResovler();
    }


}
