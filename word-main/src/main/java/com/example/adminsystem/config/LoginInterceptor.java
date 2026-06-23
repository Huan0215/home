package com.example.adminsystem.config;

import com.example.adminsystem.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        User current = null;
        if(session != null){
            current = (User) session.getAttribute("currentUser");
        }
        String uri = request.getRequestURI();
        if(uri.startsWith("/login") || uri.startsWith("/css") || uri.startsWith("/js") || uri.startsWith("/images") || uri.startsWith("/webjars")){
            return true;
        }
        if(current == null){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
