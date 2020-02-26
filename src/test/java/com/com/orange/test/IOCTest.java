package com.com.orange.test;

import com.orange.bean.Person;
import com.orange.config.MainConfig;
import com.orange.config.MainConfig2;
import org.junit.Test;
import org.omg.CORBA.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 14:13
 * 4
 * 使用junit需要再pom文件中添加相关依赖junit4.12
 */
public class IOCTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        List<String> beanNameList = Arrays.asList(applicationContext.getBeanDefinitionNames());
        for (String beanName : beanNameList) {
            System.out.println(beanName);
        }
    }

    //测试组件的作用域
    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器初始化完成了...");
        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        System.out.println(person1 == person2);
    }

    //测试condition注解
    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNames = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        System.out.println("当前操作系统为：" + env.getProperty("os.name"));
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    //测试ImportSelector组件
    @Test
    public void test04() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    //测试FactoryBean组件
    @Test
    public void test05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Object bean1 = applicationContext.getBean("colorFactoryBean");
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("作用域测试结果：" + bean1 == bean2);
        System.out.println("colorFactoryBean实例的类型" + bean1.getClass());
        Object bean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("&colorFactoryBean实例的类型" + bean3.getClass());
    }
}
