package com.demo.namespace.parser;

import com.demo.namespace.config.ApplicationConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;


/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/12/27 17:29
 **/
public class ApplicationBeanDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        //beanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(ApplicationConfig.class);
        beanDefinition.setLazyInit(false);
        //解析id
        String id = element.getAttribute("id");
        beanDefinition.getPropertyValues().add("id", id);
        //解析name
        beanDefinition.getPropertyValues().add("name",
                element.getAttribute("name"));
        //解析version
        beanDefinition.getPropertyValues().add("version",
                element.getAttribute("version"));
        //owner
        beanDefinition.getPropertyValues().add("owner",
                element.getAttribute("owner"));
        //organization
        beanDefinition.getPropertyValues().add("organization",
                element.getAttribute("organization"));

        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
        return beanDefinition;
    }
}