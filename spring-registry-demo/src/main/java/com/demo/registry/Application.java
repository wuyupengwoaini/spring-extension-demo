package com.demo.registry;

import com.demo.registry.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 15:26
 **/
@ComponentScan("com.demo.registry")
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        context.getBean(HelloService.class).sayHello();
    }
}
