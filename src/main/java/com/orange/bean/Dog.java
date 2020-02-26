package com.orange.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 13:32
 * 4
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("dog...construct...");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog...init...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("dog...destory...");
    }
}
