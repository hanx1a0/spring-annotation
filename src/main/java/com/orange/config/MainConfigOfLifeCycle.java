package com.orange.config;

import com.orange.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/26 11:13
 * 4
 */
@Configuration
@ComponentScan(value = {"com.orange.bean", "com.orange.selector"})
public class MainConfigOfLifeCycle {

    /**
     *  bean的生命周期：
     *    bean创建----初始化----销毁的过程
     *    构造（对象创建）
     *      单实例：在容器启动的时候创建对象
     *      多实例：在每次获取的时候创建对象
     *    调用beanPostProcessor.postProcessBeforeInitialization
     *    初始化：
     *      对象创建好，赋好值，调用初始化方法
     *    销毁：
     *      容器关闭时，对于单实例bean调用销毁方法，多实例bean则不管
     *
     *
     * 1.通过initMethod和destroyMethod制定初始化和销毁方法
     *
     * 2.通过让Bean实现InitializingBean(定义初始化逻辑), DisposableBean(定义销毁逻辑)接口
     *
     * 3.使用JSR250；
     *     使用@PostConstruct：在bean创建完成并且属性赋值完成，来执行初始化方法
     *     使用@PreDestory：在容器销毁bean之前通知我们进行清理工作
     *
     *
     * BeanPostProcessor的工作原理
     *  方法栈
     *  ->AnnotationConfigApplicationContext()
     *  ->AbstractApplicationContext.refresh()
     *  ->AbstractApplicationContext.finishBeanFactoryInitialization(beanFactory);
     *  ->DefaultListableBeanFactory.preInstantiateSingletons()
     *  ->AbstractBeanFactory.getBean()
     *  ->AbstractBeanFactory.doGetBean()
     *  ->DefaultSingletonBeanRegistry.getSingleton()
     *  ->AbstractAutowireCapableBeanFactory.createBean()
     *  ->AbstractAutowireCapableBeanFactory.doCreateBean()
     *  populateBean(String beanName, RootBeanDefinition mbd, BeanWrapper bw)给bean进行属性赋值
     *  ->AbstractAutowireCapableBeanFactory.initializeBean()
     *  {
     *      AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization()
     *      invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
     *      AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization()
     *  }
     *
     *  BeanPostProcessor在Spring底层的应用
     *    AutowiredAnnotationBeanPostProcessor：@Autowired注解的作用组件
     *    ApplicationContextAwareProcessor：@获取IOC容器的组件，实例如果实现了ApplicationContextAware接口，可实现setApplicationContext方法获取ioc容器
     *    AsyncAnnotationBeanPostProcessor：异步组件
     *    InitDestroyAnnotationBeanPostProcessor：init,destory
     *
     * @return
     */
    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car getCar(){
        return new Car();
    }

}
