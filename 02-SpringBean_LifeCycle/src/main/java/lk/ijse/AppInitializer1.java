package lk.ijse;

import lk.ijse.bean.SpringBean;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();// Application Context(Spring Container)
        context.register(AppConfig.class); // register the configuration
        context.refresh();// configuration is ready it to use

        SpringBean springBean = (SpringBean) context.getBean("springBean");
        System.out.println(springBean);
        context.registerShutdownHook();
    }
}