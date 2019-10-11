package com.demo.bfpp.bfpp;

import com.demo.bfpp.bean.NeedModfiyProperty;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.stereotype.Component;

/**
 * 处理所有标记了NeedModfiyProperty接口类型的对象，使得其字符串类型的value都加上五星("*****")
 *
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 14:05
 **/
@Component
public class MyPropertyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanNamesForType(NeedModfiyProperty.class, true, false);
        for (String name:names){
            BeanDefinition bd = null;
            try{
                bd = beanFactory.getBeanDefinition(name);
            }catch (NoSuchBeanDefinitionException e){

            }
            if (bd !=null && bd.hasPropertyValues()){
                MutablePropertyValues pvs = bd.getPropertyValues();
                PropertyValue[] pvArray = pvs.getPropertyValues();
                for (PropertyValue pv : pvArray){
                    Object value = pv.getValue();
                    if (value instanceof TypedStringValue){
                        TypedStringValue typedStringValue = (TypedStringValue) value;
                        String newVal = typedStringValue.getValue() + "******";
                        typedStringValue.setValue(newVal);
                        pvs.add(pv.getName(), typedStringValue);
                    }
                }
            }
        }
    }
}
