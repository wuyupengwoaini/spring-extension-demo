package com.demo.bpp.redis;

import org.springframework.stereotype.Component;

@Component
public class MyRedisConnectionFactoryImpl implements MyRedisConnectionFactory {
    @Override
    public String getRedisConnection() {
        return "MyRedisConnection";
    }
}
