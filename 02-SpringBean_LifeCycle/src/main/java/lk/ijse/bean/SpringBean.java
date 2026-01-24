package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Create Bean object automatically
@Scope("prototype")
public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean , InitializingBean {
    public SpringBean() {
        System.out.println("SpringBean is Created");//constructor when object create
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBean is set");//bean name aware - get bean name
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory is set");//
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBean is destroyed");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext is set");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
    }
}
