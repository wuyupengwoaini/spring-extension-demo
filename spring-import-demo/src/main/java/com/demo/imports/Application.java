package com.demo.imports;

import com.demo.imports.annotation.EnableBizDeferred;
import com.demo.imports.annotation.EnableMybatisMapperScan;
import com.demo.imports.annotation.EnableSelectService;
import com.demo.imports.service.BizService;
import com.demo.imports.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 15:39
 **/
@ComponentScan("com.demo.imports")
/**
 * 简单演示DeferredImportSelector的扩展，注意注册BeanDefinition的时机是最后的
 */
@EnableBizDeferred
/**
 * 如果这里修改成V3，那么容器就不会注入BizService，就会导致容器也不会注入UserService（因为UserService加了条件注解@ConditionalOnBean(BizService.class)）
 *
 * 此时条件注解是生效的，因为DeferredImportSelector是最后加载的，所以是可以读取到ImportSelector注入的BizService的BeanDefinition的。
 */
@EnableSelectService(version = EnableSelectService.ServiceVersion.V2)
/**
 * 利用ImportBeanDefinitionRegistrar扩展来模拟mybatis的mapperScan
 */
@EnableMybatisMapperScan(basePackages = {"com.demo.imports.dao"})
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        System.out.println(context.getBean(UserService.class).getUserName());

        context.getBean(BizService.class).doBiz();
    }
}
