package com.orange.config;

import com.orange.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 13:56
 * 4
 * 配置类==配置文件
 */

@Configuration //通知Spring这是一个配置类
@ComponentScan(value = "com.orange", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
}, useDefaultFilters = false)
/*@ComponentScan(value = "com.orange", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
}, useDefaultFilters = false)*/
//@ComponentScan注解
//    value: 指定要扫描的包
//    excludeFilters: Filter[]，指定包扫描时需要排除哪些组件
//    includeFilters: Filter[]，指定包扫描时只包含哪些组件，使用时需要注意将默认的过滤规则禁用useDefaultFilters = false
//    type过滤模式分以下几种：
//        ANNOTATION: 注解类型 Controller, Service, Repository
//        ASSIGNABLE_TYPE: 定义类型, BookDao, BookService
//        ASPECTJ: aspectj表达式
//        REGEX: 匹配正则表达式
//        CUSTOM: 自定义类型（需要实现TypeFilter）
public class MainConfig {

    @Bean
    public Person person() {
        return new Person("hanx1a02", "25");
    }
}
