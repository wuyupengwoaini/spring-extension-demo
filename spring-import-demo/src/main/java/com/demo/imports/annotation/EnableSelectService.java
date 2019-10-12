package com.demo.imports.annotation;

import com.demo.imports.selector.BizImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 根据配置的version来选择将对应的service注入到Spring容器中
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 15:50
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(BizImportSelector.class)
public @interface EnableSelectService {

    ServiceVersion version();

    enum ServiceVersion{
        V1,V2,V3
    }

}
