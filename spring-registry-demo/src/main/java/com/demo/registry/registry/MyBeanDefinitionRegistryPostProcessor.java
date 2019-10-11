package com.demo.registry.registry;

import com.demo.registry.service.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 15:27
 **/
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        /**
         * 这里只是简单演示一下BeanDefinitionRegistryPostProcessor的动态注册bean的功能。
         *
         * 实际上我们在使用java config或者SpringBoot环境下很少直接自定义BeanDefinitionRegistryPostProcessor，
         * 而是结合使用@Import来实现动态注册Bean。可以参考spring-import-demo模块
         */
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(HelloService.class);
        registry.registerBeanDefinition("helloService",builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // do nothing
    }
}
