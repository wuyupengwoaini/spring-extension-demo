package com.demo.bpp;

import com.demo.bpp.redis.MyRedisConnectionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/12 9:53
 **/
@ComponentScan("com.demo.bpp")
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        System.out.println(context.getBean(MyRedisConnectionFactory.class).getRedisConnection());
    }
}

