package lk.ijse;

import lk.ijse.config.AppConfig;
import lk.ijse.config.AppConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer4 {
    public static void main(String[] args) {
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
     context.register(AppConfig.class);
        context.refresh();

     context.registerShutdownHook();

    }
}