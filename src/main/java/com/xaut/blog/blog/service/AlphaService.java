package com.xaut.blog.blog.service;

import com.xaut.blog.blog.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")//不写的话，默认是单例Scope("Singleton")
public class AlphaService {
//    @Autowired
    private AlphaDao alphaDao;
    public AlphaService(){
        System.out.println("实例化AlphaService");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁AlphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
