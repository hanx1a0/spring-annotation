package com.orange.selector;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 13:49
 * 4
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization------>object:"+o.getClass() + ", string:"+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization------>object:"+o.getClass() + ", string:"+s);
        return o;
    }
}
