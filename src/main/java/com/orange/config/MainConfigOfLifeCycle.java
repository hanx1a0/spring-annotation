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
     *
     *
     *   自动装配;
     *   		Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；
     *
     *   1）、@Autowired：自动注入：
     *   		1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
     *   		2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
     *   							applicationContext.getBean("bookDao")
     *   		3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
     *   		4）、自动装配默认一定要将属性赋值好，没有就会报错；
     *   			可以使用@Autowired(required=false);
     *   		5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean；
     *   				也可以继续使用@Qualifier指定需要装配的bean的名字
     *   		BookService{
     *   			@Autowired
     *   			BookDao  bookDao;
     *   		}
     *
     *   2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
     *   		@Resource:
     *   			可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
     *   			没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
     *   		@Inject:
     *   			需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
     *    @Autowired:Spring定义的； @Resource、@Inject都是java规范
     *
     *   AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；
     *
     *   3）、 @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
     *   		1）、[标注在方法位置]：@Bean+方法参数；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
     *   		2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
     *   		3）、放在参数位置：
     *
     *   4）、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；
     *   		自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；
     *   		把Spring底层一些组件注入到自定义的Bean中；
     *   		xxxAware：功能使用xxxProcessor；
     *   			ApplicationContextAware==》ApplicationContextAwareProcessor；
     *
     * @return
     */
    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car getCar(){
        return new Car();
    }

}
