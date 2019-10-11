package com.demo.bfpp;

import com.demo.bfpp.bean.InitTestBean;
import com.demo.bfpp.bean.PropertyTestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 13:57
 **/
@ComponentScan("com.demo.bfpp")
@ImportResource("classpath:spring-ext.xml")
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        /**
         * 打印结果：PropertyTestBean{p1='p1******', p2='p2******'}
         *
         */
        System.out.println(context.getBean(PropertyTestBean.class));
        /**
         * 打印结果：InitTestBean{initName='init'}
         */
        System.out.println(context.getBean(InitTestBean.class));
    }
}
