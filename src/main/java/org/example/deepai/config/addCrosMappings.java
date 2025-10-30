package org.example.deepai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class addCrosMappings implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("设置允许跨域访问");
        registry.addMapping("/**")
                .allowedOriginPatterns("http://*","https://*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}
