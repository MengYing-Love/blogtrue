package com.xaut.blog.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.SimpleDateFormat;

@Configuration
@Scope("prototype")
//1、这块也可以使用@SpringBootApplication注解，但一般不这样用，程序入口用这个。
//2、@Configuration注解表明，这个类不是普通的类，而是一个配置类
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy MM-dd HH:mm:ss");
    }


}
