package com.rico.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Rico_dds
 * @date 2020/7/27 9:32
 */
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有则使用默认的
        //如果lang不为空，携带了国际化的参数
        if(!StringUtils.isEmpty(lang)){
            String[] s = lang.split("_");
            //得到国家和地区
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
