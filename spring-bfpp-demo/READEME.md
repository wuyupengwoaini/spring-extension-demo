# `BeanFactoryPostProcessor`
> 本模块主要是为了演示Spring扩展点之一`BeanFactoryPostProcessor`的使用。`BeanFactoryPostProcessor`
主要是为了在Spring容器初始化并且转载好所有的`BeanDefinition`之后来修改`BeanDefinition`,从而影响bean的行为


## 使用案例说明

> 注意案例中的所有例子仅仅用于学习使用，不可用于生产环境

本模块演示了两种`BeanFactoryPostProcessor`的使用方式：
`AddInitMethodBeanFactoryPostProcessor`  演示添加初始化方法
`MyPropertyBeanFactoryPostProcessor`  演示把所有实现了NeedModfiyProperty接口的类中的所有String例行的属性值都加上五星