# `BeanDefinitionRegistryPostProcessor`
> 本模块主要是为了演示Spring扩展点之一`BeanDefinitionRegistryPostProcessor`的使用。`BeanDefinitionRegistryPostProcessor`
主要是为了在Spring容器初始化并且转载好所有的`BeanDefinition`之后来动态注册`BeanDefinition`,从而可以实现动态注册Bean的功能


## 使用案例说明

> 注意案例中的所有例子仅仅用于学习使用，不可用于生产环境

使用`MyBeanDefinitionRegistryPostProcessor`来动态注册`HelloService`(注意`HelloService`没有添加@Component注解)