package com.wzw.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在链接上携带区域信息
 */
public class MyLocaleResovler implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取l的值，l='zh_CN'或者l='en_US'
        String l = request.getParameter("l");
        //直接取默认的区域信息
        Locale locale=Locale.getDefault();
        //先判断区域信息是否为空，如果不是空的，就改变它的区域信息，如果是空的，直接返回默认的
        if(!StringUtils.isEmpty(l)){
            //因为它的值是l='zh_CN'或者l='en_US'，将它分割成一个数组
            String[] split = l.split("_");
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
