package com.demo.imports.annotation;

import com.demo.imports.selector.BizDeferredImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 16:36
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(BizDeferredImportSelector.class)
public @interface EnableBizDeferred {
}
