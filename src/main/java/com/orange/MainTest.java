package com.orange;

import com.orange.bean.Person;
import com.orange.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 13:24
 * 4
 */
public class MainTest {

    public static void main(String[] args){
        /*基于配置文件的方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(applicationContext.getBean(Person.class));*/
        /*基于注解的方式*/
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(applicationContext.getBean(Person.class));

    }

}
