package com.demo.bpp.tracing;

import com.demo.bpp.redis.MyRedisConnectionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 把模拟的RedisConnectionFactory[MyTracingRedisConnectionFactoryImpl]替换为
 * 带有模拟Tracing功能的RedisConnectionFactory(MyTracingRedisConnectionFactoryImpl)
 */
@Component
public class MyTracingBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyRedisConnectionFactory && !(bean instanceof MyTracingRedisConnectionFactoryImpl)){
            System.out.println("替换MyRedisConnectionFactory为MyTracingRedisConnectionFactoryImpl");
            return new MyTracingRedisConnectionFactoryImpl((MyRedisConnectionFactory)bean);
        }
        return bean;
    }
}
