package com.company.config;

import com.company.annotation.RequiredPermission;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yaochunguang
 * @date: 2021-03-04 16:42
 * @description: 权限拦截器
 **/
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从request Headers中获取用户身份信息，如token； 获取用户权限信息
        List<String> perms = Arrays.asList("perm:read", "perm:write");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequiredPermission permission = handlerMethod.getMethod().getDeclaredAnnotation(RequiredPermission.class);
            if (permission != null) {
                if (perms.contains(permission.value())) {
                    return true;
                } else {
                    throw new IllegalAccessException("非法访问");
                }
            }
        }
        return true;
    }
}
