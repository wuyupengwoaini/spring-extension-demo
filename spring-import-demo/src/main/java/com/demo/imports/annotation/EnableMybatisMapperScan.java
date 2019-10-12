package com.demo.imports.annotation;

import com.demo.imports.selector.BizImportSelector;
import com.demo.imports.selector.MockMybatisMapperRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模拟mybatis的mapper使用方式来演示ImportBeanDefinitionRegistrar的扩展
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 16:46
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MockMybatisMapperRegistrar.class)
public @interface EnableMybatisMapperScan {
    String[] basePackages();
}
