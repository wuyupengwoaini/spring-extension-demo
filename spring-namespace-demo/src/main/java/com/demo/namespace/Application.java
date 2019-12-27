package com.demo.namespace;

import com.demo.namespace.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 15:26
 **/
@ImportResource("classpath:spring.xml")
@ComponentScan("com.demo.namespace")
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ApplicationConfig config = context.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}