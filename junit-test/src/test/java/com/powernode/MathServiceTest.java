package com.powernode;

import org.junit.Assert;
import org.junit.Test;

public class MathServiceTest {
    //一般一个业务方法对应一个测试方法、
    //测试方法的规范：public void testxxx(){}
    //测试方法的方法名以test开始，假设测试的方法是sum，方法名是：testSum
    //@Test注解非常重要，被这个注解标注的方法就是一个单元测试方法
    @Test
    public void testSum(){
        MathService mathService=new MathService();
        //获取实际值
        int actual=mathService.sum(1,2);
        //加断言进行测试
        Assert.assertEquals(3,actual);
    }
    @Test
    public void testSub(){
        MathService mathService=new MathService();
        int actual=mathService.sub(10,5);
        Assert.assertEquals(5,5);
    }
}
