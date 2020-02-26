package com.com.orange.test;

import com.orange.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 11:26
 * 4
 */
public class IOCTestLifeCycle {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器被创建...");

        applicationContext.getBean("getCar");

        applicationContext.getBean("cat");
        applicationContext.getBean("cat");

        applicationContext.close();
        System.out.println("容器被销毁...");
    }

}
