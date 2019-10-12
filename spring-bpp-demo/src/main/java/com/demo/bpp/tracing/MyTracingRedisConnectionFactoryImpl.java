package com.demo.bpp.tracing;

import com.demo.bpp.redis.MyRedisConnectionFactory;

/**
 * 模拟RedisConnectionFactory的默认实现
 */
public class MyTracingRedisConnectionFactoryImpl implements MyRedisConnectionFactory {

    private MyRedisConnectionFactory delegate;

    public MyTracingRedisConnectionFactoryImpl(MyRedisConnectionFactory delegate){
        this.delegate = delegate;
    }

    @Override
    public String getRedisConnection() {
        return "tracing----------" + delegate.getRedisConnection();
    }
}
