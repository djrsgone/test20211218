package com.djr.demo;

import com.djr.demo.jwt.JwtUtils;
import com.djr.demo.jwt.NeedToLogin;
import com.djr.demo.jwt.PassToken;
import com.djr.demo.jwt.UserNotExist;
import com.djr.demo.service.AccountService;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = httpServletRequest.getHeader("token");
        System.err.println("token=" + token);

        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //by default, check all requests
        else {
            System.out.println("被jwt拦截需要验证");
            if (token == null) {
                throw new NeedToLogin();
            }

            //parse userId from token
            String userId = JwtUtils.getAudience(token);
            if(StringUtils.isNullOrEmpty(userId) || !JwtUtils.USER_ID.equals(userId)){
                throw new UserNotExist();
            }

            //verify
            JwtUtils.verifyToken(token, userId);

            //get payload
            String userName = JwtUtils.getClaimByName(token, "userName").asString();
            String realName = JwtUtils.getClaimByName(token, "realName").asString();

            //put attributes into request
            httpServletRequest.setAttribute("userName", userName);
            httpServletRequest.setAttribute("realName", realName);


            return true;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
