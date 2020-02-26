package com.orange.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 13:20
 * 4
 */
@Scope("prototype")
@Component
public class Cat implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }
}
