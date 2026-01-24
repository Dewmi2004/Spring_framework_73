package lk.ijse;

import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer3 {
    public static void main(String[] args) {
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
     context.register(AppConfig.class);
        context.refresh();

     context.registerShutdownHook();

    }
}