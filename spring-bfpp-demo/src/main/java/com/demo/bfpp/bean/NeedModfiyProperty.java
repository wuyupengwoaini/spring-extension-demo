package com.demo.bfpp.bean;

/**
 * mark interface
 *
 * 所有标记了该接口的类的所有String类型的属性都需要加上5个星号
 *
 * eg:
 * class Demo implements NeedModfiyProperty{
 *     private String name = "hello"
 * }
 *
 * 当容器初始化之后name的值为"hello******"
 */
public interface NeedModfiyProperty {
}
