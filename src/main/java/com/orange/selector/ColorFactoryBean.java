package com.orange.selector;

import com.orange.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 10:56
 * 4
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        System.out.println("获取Color实例....");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 控制FactoryBean是否为单实例(true)/多实例(false)
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
