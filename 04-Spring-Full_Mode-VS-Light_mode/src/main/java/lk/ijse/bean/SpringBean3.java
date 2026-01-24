package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean3 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean, InitializingBean {
    // Light mode - bean method defined inside a bean class
    @Bean
    public SpringBean1 springBean1(){
        //No Inter Bean dependency - NO satisfy inter bean dependency in Light mode (call a bean inside another bean)
        SpringBean2 sp1 = springBean2();//it is like normal POJO - just a object with different reference
        SpringBean2 sp2 = springBean2();//it is like normal POJO - just a object with different reference
        System.out.println(sp1);
        System.out.println(sp2);
        return new SpringBean1();
    }
    @Bean
    public SpringBean2 springBean2(){
        return new SpringBean2();
    }
    public SpringBean3() {
        System.out.println("SpringBean-3");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }
}
