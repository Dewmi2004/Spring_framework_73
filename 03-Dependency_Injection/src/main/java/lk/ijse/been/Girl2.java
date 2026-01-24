package lk.ijse.been;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary // we can decide which component should be prioritized between more than one component
@Component
public class Girl2 implements Agreement, BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean, InitializingBean {
    public Girl2(){
        System.out.println("Girl-2 object created");
    }
    @Override
    public void Chat() {
        System.out.println("Girl-2 chat");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext setApplicationContext");
    }
}
