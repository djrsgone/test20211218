package com.example.firstappdemo.config;

import com.example.firstappdemo.domain.User;
import com.example.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *  请求接口： ServletRequest 或者HttpServletRequest
     *  响应接口： ServletResponse 或者 HttpServletResponse
     *
     *  spring 5.0 重新定义服务请求和响应接口
     *  请求接口： ServerRequest
     *  响应接口： ServerResponse
     *  既可支持Servlet规范，也可以支持自定义，比如Netty（Web Server)
     *
     *  本例：
     *  定义一个Get请求，并且返回所有的用户对象 URL：/person/find/all
     */
//    @Bean
//    @Autowired
//    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
//
//        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
//                request -> {
//                    //返回所有用户列表
//                    Collection<User> users = userRepository.findAll();
//                    Flux<User> userFlux = Flux.fromIterable(users);
//                    return ServerResponse.ok().body(userFlux, User.class);
//                }
//        );
//    }


}

