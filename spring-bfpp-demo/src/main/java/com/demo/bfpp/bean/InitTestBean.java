package com.demo.bfpp.bean;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 14:00
 **/
@Component("initTestBean")
public class InitTestBean {

    private String initName;

    public String getInitName() {
        return initName;
    }

    public void setInitName(String initName) {
        this.initName = initName;
    }

    public void init(){
        this.initName = "init";
        System.out.println("---------InitTestBean init invoked-------");
    }

    @Override
    public String toString() {
        return "InitTestBean{" +
                "initName='" + initName + '\'' +
                '}';
    }
}
