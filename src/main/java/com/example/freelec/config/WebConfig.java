package com.example.freelec.config;

import com.example.freelec.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
// LUAR이 스프링안에서 인식될 수 있도록 webMvcConfigurer에 추가
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    // HMAR는 항상 WConfigurer의 addArgumentResolvers() 통해 추가해야 함.
    // 다른 Handler-MethodArgumentResolver가 필요하다면 같은 방식으로 추가하면 됨.
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}