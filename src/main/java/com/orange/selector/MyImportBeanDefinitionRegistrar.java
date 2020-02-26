package com.orange.selector;

import com.orange.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 10:43
 * 4
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean beanExists = beanDefinitionRegistry.containsBeanDefinition("com.orange.bean.Red");
        boolean beanExists2 = beanDefinitionRegistry.containsBeanDefinition("com.orange.bean.Blue");
        if(beanExists && beanExists2) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("myRainBow", rootBeanDefinition);
        }
    }
}
