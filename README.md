
# Spring Extension Examples

本项目主要用于演示Spring的主要的扩展点，以方便开发者学习如何将自己的框架融合到Spring框架中。

本项目每一个模块都对应着一种主要的Spring扩展点，对应关系如下：

模块 | Spring扩展点| 总结
--------| -------| --------
spring-bfpp-demo | `BeanFactoryPostProcessor`|用于修改Sping加载好的`BeanDefinition`
spring-registry-demo  | `BeanDefinitionRegistryPostProcessor`|动态向Spring容器中添加`BeanDefinition`
spring-import-demo  | `@Import`|动态向Spring容器中添加`BeanDefinition`,SpringBoot中的`Enablexxx`注解都是通过这种方式实现的
spring-bpp-demo  | `BeanPostProcessor`|插手Bean的实例化过程，可以在Bean初始化前后来修改Bean

## Spring扩展点之-- `BeanFactoryPostProcessor`
`BeanFactoryPostProcessor`很多开发者也叫它`后置工厂处理器`。其实单从名字上是很难知道其最主要的作用的

## Spring扩展点之-- `BeanDefinitionRegistryPostProcessor`

## Spring扩展点之-- `@Import`

## Spring扩展点之-- `BeanPostProcessor`

## Spring扩展点之-- `NameSpaceHandler`