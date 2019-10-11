package com.demo.bfpp.bean;
/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 14:10
 **/
public class PropertyTestBean implements NeedModfiyProperty {
    private String p1;

    private String p2;

    @Override
    public String toString() {
        return "PropertyTestBean{" +
                "p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                '}';
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
