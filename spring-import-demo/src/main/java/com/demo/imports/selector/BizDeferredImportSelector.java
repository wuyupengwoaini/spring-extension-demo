package com.demo.imports.selector;

import com.demo.imports.service.UserService;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * DeferredImportSelector跟ImportSelector对的用法几乎一致。不一样的就在于注册BeanDefinition的时机不同
 *
 * DeferredImportSelector注册BeanDefinition是在Spring注册完所有的@Configuration的Bean之后再注册，也在ImportSelector之后
 *
 * 这对于使用{@Conditional}注解的Bean尤其有作用
 *
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 16:25
 **/
public class BizDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{UserService.class.getName()};
    }
}
