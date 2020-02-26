package com.orange.config;

import com.orange.bean.Color;
import com.orange.bean.Person;
import com.orange.bean.Red;
import com.orange.condition.LinuxCondition;
import com.orange.condition.WindowCondition;
import com.orange.selector.ColorFactoryBean;
import com.orange.selector.MyImportBeanDefinitionRegistrar;
import com.orange.selector.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 15:08
 * 4
 * 用于测试组件的作用域
 */
@Configuration
@Import(value = {Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /*Scope默认是单实例的 value: 组件作用域{"prototype", "singleton", "session", "request"}
      prototype: 多实例，ioc容器启动时不会初始化该对象，只有当获取时才会去创建对象实例。
      singleton: 单实例， ioc容器启动时就会调用方法创建对象放到容器中去，以后每次获取都是直接从容器中拿（map.get）即可。
      session: 同一个session创建一个实例
      request：同一个请求创建一次实例

      懒加载的概念，使单实例Bean不默认在容器启动的时候创建实例，而是在使用时才去创建，使用@Lazy

      @Conditional可以根据条件初始化实例
     */
    @Lazy
    @Scope(value = "singleton")
    @Bean
    public Person person() {
        System.out.println("我被初始化到IOC容器中了...");
        return new Person("hanx1a03", "30");
    }

    @Bean
    @Conditional(WindowCondition.class)
    public Person person01() {
        return new Person("Bill Gates", "48");
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public Person person02() {
        return new Person("linus", "60");
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

    /**
     * 给容器中注册组件
     * 1）、包扫描+组件标注注解 (@Controller/@Service/@Repository/@Component)
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     *   1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全限定类名
     *   2）、@ImportSelector：返回需要导入的组件的全类名数组
     *   3）、@ImportBeanDefinitionRegistrar：手动注册bean到容器中
     *   4）、使用spring的FactoryBean（工厂Bean）--->默认获取的是工bean调用getObject方法创建的对象，若要获取工厂实例本身则需要在id前增加一个&
     */

}
