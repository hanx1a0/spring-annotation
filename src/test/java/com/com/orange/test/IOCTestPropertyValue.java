package com.com.orange.test;

import com.orange.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 16:19
 * 4
 */
public class IOCTestPropertyValue {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        printBeans(applicationContext);
        System.out.println(applicationContext.getBean("person"));
    }

    public void printBeans(ApplicationContext applicationContext){
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
