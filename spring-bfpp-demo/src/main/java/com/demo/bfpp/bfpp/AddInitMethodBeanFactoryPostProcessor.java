package com.demo.bfpp.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 演示利用BeanFactoryPostProcessor来修改BeanDefinition的初始化方法
 *
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 13:59
 **/
@Component
public class AddInitMethodBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("initTestBean");
        // 添加initTestBean的初始化为init,容器启动会自动调用InitTestBean的init()方法
        bd.setInitMethodName("init");
    }
}
