package com.demo.namespace.handler;

import com.demo.namespace.parser.ApplicationBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/12/27 17:28
 **/
public class BridgeNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("application",
                new ApplicationBeanDefinitionParser());
    }
}
