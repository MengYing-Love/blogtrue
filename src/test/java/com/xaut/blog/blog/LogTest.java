package com.xaut.blog.blog;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = BlogApplication.class)
public class LogTest {
    //实例化log的组件(接口)
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void  testLogger(){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
